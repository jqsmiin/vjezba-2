package com.example.vjezba2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guestName;

    @Column(nullable = false)
    private String guestEmail;

    @Column(nullable = false)
    private String guestPhone;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private int numberOfGuests;

    @Column(nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private String status; // PENDING, CONFIRMED, CANCELLED

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public Reservation(String johnDoe, String mail, String s, LocalDate localDate, LocalDate localDate1, int i, double v, String confirmed, Hotel hotel1) {
    }
}

