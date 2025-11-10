package com.example.vjezba2.controller;

import com.example.vjezba2.model.Reservation;
import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.repository.ReservationRepository;
import com.example.vjezba2.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/c")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // List all reservations
    @GetMapping
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        return "listC";
    }

    // View reservation details
    @GetMapping("/view/{id}")
    public String viewReservation(@PathVariable("id") Long id, Model model) {
        Optional<Reservation> reservationOpt = reservationRepository.findById(id);
        if (reservationOpt.isPresent()) {
            model.addAttribute("reservation", reservationOpt.get());
            return "reservationDetail";
        }
        return "redirect:/c";
    }

    // Show form to create new reservation
    @GetMapping("/new")
    public String showCreateReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("hotels", hotelRepository.findAll());
        return "reservationForm";
    }

    // Create new reservation
    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation, @RequestParam("hotelId") Long hotelId) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(hotelId);
        if (hotelOpt.isPresent()) {
            reservation.setHotel(hotelOpt.get());
            reservationRepository.save(reservation);
        }
        return "redirect:/c";
    }

    // Show form to edit reservation
    @GetMapping("/edit/{id}")
    public String showEditReservationForm(@PathVariable("id") Long id, Model model) {
        Optional<Reservation> reservationOpt = reservationRepository.findById(id);
        if (reservationOpt.isPresent()) {
            model.addAttribute("reservation", reservationOpt.get());
            model.addAttribute("hotels", hotelRepository.findAll());
            return "reservationForm";
        }
        return "redirect:/c";
    }

    // Update reservation
    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable("id") Long id, @ModelAttribute Reservation reservationDetails, 
                                   @RequestParam("hotelId") Long hotelId) {
        Optional<Reservation> reservationOpt = reservationRepository.findById(id);
        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            reservation.setGuestName(reservationDetails.getGuestName());
            reservation.setGuestEmail(reservationDetails.getGuestEmail());
            reservation.setGuestPhone(reservationDetails.getGuestPhone());
            reservation.setCheckInDate(reservationDetails.getCheckInDate());
            reservation.setCheckOutDate(reservationDetails.getCheckOutDate());
            reservation.setNumberOfGuests(reservationDetails.getNumberOfGuests());
            reservation.setTotalPrice(reservationDetails.getTotalPrice());
            reservation.setStatus(reservationDetails.getStatus());
            
            Optional<Hotel> hotelOpt = hotelRepository.findById(hotelId);
            if (hotelOpt.isPresent()) {
                reservation.setHotel(hotelOpt.get());
            }
            
            reservationRepository.save(reservation);
        }
        return "redirect:/c";
    }

    // Delete reservations
    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") Long id) {
        reservationRepository.deleteById(id);
        return "redirect:/c";
    }
}

