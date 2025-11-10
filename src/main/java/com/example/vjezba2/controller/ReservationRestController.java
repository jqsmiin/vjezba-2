package com.example.vjezba2.controller;

import com.example.vjezba2.model.Reservation;
import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.repository.ReservationRepository;
import com.example.vjezba2.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // GET all reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservations);
    }

    // GET reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET reservations by hotel ID
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Reservation>> getReservationsByHotel(@PathVariable Long hotelId) {
        List<Reservation> reservations = reservationRepository.findByHotelId(hotelId);
        return ResponseEntity.ok(reservations);
    }

    // GET reservations by status
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reservation>> getReservationsByStatus(@PathVariable String status) {
        List<Reservation> reservations = reservationRepository.findByStatus(status);
        return ResponseEntity.ok(reservations);
    }

    // POST create new reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            if (reservation.getHotel() != null && reservation.getHotel().getId() != null) {
                Optional<Hotel> hotel = hotelRepository.findById(reservation.getHotel().getId());
                if (hotel.isPresent()) {
                    reservation.setHotel(hotel.get());
                    Reservation savedReservation = reservationRepository.save(reservation);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedReservation);
                } else {
                    return ResponseEntity.badRequest().build();
                }
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT update reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservationDetails) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation reservation = optionalReservation.get();
            reservation.setGuestName(reservationDetails.getGuestName());
            reservation.setGuestEmail(reservationDetails.getGuestEmail());
            reservation.setGuestPhone(reservationDetails.getGuestPhone());
            reservation.setCheckInDate(reservationDetails.getCheckInDate());
            reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
            reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
            reservation.setTotalPrice(reservationDetails.getTotalPrice());
            reservation.setStatus(reservationDetails.getStatus());
            
            Reservation updatedReservation = reservationRepository.save(reservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

