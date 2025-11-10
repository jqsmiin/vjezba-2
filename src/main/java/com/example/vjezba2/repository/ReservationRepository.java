package com.example.vjezba2.repository;

import com.example.vjezba2.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByHotelId(Long hotelId);
    List<Reservation> findByStatus(String status);
    List<Reservation> findByGuestEmail(String guestEmail);
}

