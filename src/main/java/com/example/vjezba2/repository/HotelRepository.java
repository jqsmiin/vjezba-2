package com.example.vjezba2.repository;

import com.example.vjezba2.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String city);
    List<Hotel> findByStars(int stars);
}

