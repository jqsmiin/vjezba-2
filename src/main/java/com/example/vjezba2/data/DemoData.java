package com.example.vjezba2.data;

import com.example.vjezba2.model.Hotel;
import com.example.vjezba2.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DemoData {
    public static List<Hotel> hotels = new ArrayList<Hotel>();

    static {
        List<Room> rooms1 = new ArrayList<Room>();
        rooms1.add(new Room(1, "101", "Single", 50.0, true));
        rooms1.add(new Room(2, "102", "Double", 75.0, false));
        Hotel h1 = new Hotel(1, "Sunrise Hotel", "Zagreb", "Main St 1", 4, rooms1);

        List<Room> rooms2 = new ArrayList<Room>();
        rooms2.add(new Room(3, "201", "Suite", 120.0, true));
        rooms2.add(new Room(4, "202", "Single", 55.0, true));
        Hotel h2 = new Hotel(2, "Sea Breeze", "Split", "Coast Rd 5", 3, rooms2);

        hotels.add(h1);
        hotels.add(h2);
    }
}


