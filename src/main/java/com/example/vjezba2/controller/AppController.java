package com.example.vjezba2.controller;

import com.example.vjezba2.data.DemoData;
import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    @GetMapping("/a")
    public String listHotels(Model model) {
        model.addAttribute("hotels", DemoData.hotels);
        return "listA";
    }

    @GetMapping("/b")
    public String listRooms(Model model) {
        List<Room> allRooms = new ArrayList<Room>();
        for (int i = 0; i < DemoData.hotels.size(); i++) {
            Hotel h = DemoData.hotels.get(i);
            List<Room> rooms = h.getRooms();
            for (int j = 0; j < rooms.size(); j++) {
                allRooms.add(rooms.get(j));
            }
        }
        model.addAttribute("rooms", allRooms);
        return "listB";
    }

    @GetMapping("/a/action/{id}")
    public String hotelDetail(@PathVariable("id") int id, Model model) {
        Hotel found = null;
        for (int i = 0; i < DemoData.hotels.size(); i++) {
            Hotel h = DemoData.hotels.get(i);
            if (h.getId() == id) {
                found = h;
                break;
            }
        }
        model.addAttribute("hotel", found);
        if (found != null) {
            model.addAttribute("rooms", found.getRooms());
        } else {
            model.addAttribute("rooms", new ArrayList<Room>());
        }
        return "action";
    }
}


