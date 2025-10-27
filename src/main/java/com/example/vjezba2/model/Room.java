package com.example.vjezba2.model;

public class Room {
    private int id;
    private String number;
    private String type;
    private double price;
    private boolean available;

    public Room(int id, String number, String type, double price, boolean available) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}


