package com.example.vjezba2.controller;

import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.model.Room;
import com.example.vjezba2.repository.HotelRepository;
import com.example.vjezba2.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    // List all hotels
    @GetMapping("/a")
    public String listHotels(Model model) {
        List<Hotel> hotels = hotelRepository.findAll();
        model.addAttribute("hotels", hotels);
        return "listA";
    }

    // List all rooms
    @GetMapping("/b")
    public String listRooms(Model model) {
        List<Room> allRooms = roomRepository.findAll();
        model.addAttribute("rooms", allRooms);
        return "listB";
    }

    // View hotel details with rooms
    @GetMapping("/a/action/{id}")
    public String hotelDetail(@PathVariable("id") Long id, Model model) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        if (hotelOpt.isPresent()) {
            Hotel hotel = hotelOpt.get();
            model.addAttribute("hotel", hotel);
            model.addAttribute("rooms", hotel.getRooms());
        } else {
            model.addAttribute("hotel", null);
            model.addAttribute("rooms", List.of());
        }
        return "action";
    }

    // Show form to create new hotel
    @GetMapping("/a/new")
    public String showCreateHotelForm(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotelForm";
    }

    // Create new hotel
    @PostMapping("/a/save")
    public String saveHotel(@ModelAttribute Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/a";
    }

    // Show form to edit hotel
    @GetMapping("/a/edit/{id}")
    public String showEditHotelForm(@PathVariable("id") Long id, Model model) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        if (hotelOpt.isPresent()) {
            model.addAttribute("hotel", hotelOpt.get());
            return "hotelForm";
        }
        return "redirect:/a";
    }

    // Update hotel
    @PostMapping("/a/update/{id}")
    public String updateHotel(@PathVariable("id") Long id, @ModelAttribute Hotel hotelDetails) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        if (hotelOpt.isPresent()) {
            Hotel hotel = hotelOpt.get();
            hotel.setName(hotelDetails.getName());
            hotel.setCity(hotelDetails.getCity());
            hotel.setAddress(hotelDetails.getAddress());
            hotel.setStars(hotelDetails.getStars());
            hotelRepository.save(hotel);
        }
        return "redirect:/a";
    }

    // Delete hotel
    @GetMapping("/a/delete/{id}")
    public String deleteHotel(@PathVariable("id") Long id) {
        hotelRepository.deleteById(id);
        return "redirect:/a";
    }
}


