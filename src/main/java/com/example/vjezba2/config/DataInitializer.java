package com.example.vjezba2.config;

import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.model.Room;
import com.example.vjezba2.model.Reservation;
import com.example.vjezba2.repository.HotelRepository;
import com.example.vjezba2.repository.RoomRepository;
import com.example.vjezba2.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(HotelRepository hotelRepository, 
                                   RoomRepository roomRepository,
                                   ReservationRepository reservationRepository) {
        return args -> {
            if (hotelRepository.count() > 0) {
                System.out.println("Database already initialized. Skipping data initialization.");
                return;
            }

            System.out.println("Initializing database with sample data...");

            // Create Hotel 1
            Hotel hotel1 = new Hotel("Sunrise Hotel", "Zagreb", "Main St 1", 4);
            hotelRepository.save(hotel1);

            Room room1 = new Room("101", "Single", 50.0, true);
            room1.setHotel(hotel1);
            roomRepository.save(room1);

            Room room2 = new Room("102", "Double", 75.0, false);
            room2.setHotel(hotel1);
            roomRepository.save(room2);

            Room room3 = new Room("103", "Suite", 150.0, true);
            room3.setHotel(hotel1);
            roomRepository.save(room3);

            // Create Hotel 2
            Hotel hotel2 = new Hotel("Sea Breeze", "Split", "Coast Rd 5", 3);
            hotelRepository.save(hotel2);

            Room room4 = new Room("201", "Suite", 120.0, true);
            room4.setHotel(hotel2);
            roomRepository.save(room4);

            Room room5 = new Room("202", "Single", 55.0, true);
            room5.setHotel(hotel2);
            roomRepository.save(room5);

            Room room6 = new Room("203", "Double", 80.0, false);
            room6.setHotel(hotel2);
            roomRepository.save(room6);

            // Create Hotel 3
            Hotel hotel3 = new Hotel("Mountain View Resort", "Dubrovnik", "Hill Road 10", 5);
            hotelRepository.save(hotel3);

            Room room7 = new Room("301", "Deluxe Suite", 200.0, true);
            room7.setHotel(hotel3);
            roomRepository.save(room7);

            Room room8 = new Room("302", "Presidential Suite", 350.0, true);
            room8.setHotel(hotel3);
            roomRepository.save(room8);

            // Create sample reservations
            Reservation reservation1 = new Reservation(
                "John Doe",
                "john.doe@email.com",
                "+385-91-123-4567",
                LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(8),
                2,
                225.0,
                "CONFIRMED",
                hotel1
            );
            reservationRepository.save(reservation1);

            Reservation reservation2 = new Reservation(
                "Jane Smith",
                "jane.smith@email.com",
                "+385-91-234-5678",
                LocalDate.now().plusDays(10),
                LocalDate.now().plusDays(15),
                4,
                600.0,
                "PENDING",
                hotel2
            );
            reservationRepository.save(reservation2);

            Reservation reservation3 = new Reservation(
                "Mike Johnson",
                "mike.j@email.com",
                "+385-91-345-6789",
                LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(4),
                2,
                400.0,
                "CONFIRMED",
                hotel3
            );
            reservationRepository.save(reservation3);

            Reservation reservation4 = new Reservation(
                "Sarah Williams",
                "sarah.w@email.com",
                "+385-91-456-7890",
                LocalDate.now().minusDays(5),
                LocalDate.now().minusDays(2),
                1,
                150.0,
                "CANCELLED",
                hotel1
            );
            reservationRepository.save(reservation4);

            System.out.println("Database initialization completed!");
            System.out.println("Created " + hotelRepository.count() + " hotels");
            System.out.println("Created " + roomRepository.count() + " rooms");
            System.out.println("Created " + reservationRepository.count() + " reservations");
        };
    }
}

