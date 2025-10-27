package com.example.vjezba2.model;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String city;
    private String address;
    private int stars;
    private List<Room> rooms;

    public Hotel(int id, String name, String city, String address, int stars, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.stars = stars;
        this.rooms = rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}


