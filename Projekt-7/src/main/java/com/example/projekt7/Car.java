package com.example.projekt7;

public class Car {
    private static int nextId = 0;
    private int id;
    private String carname;
    private String brand;

    public Car(String carname, String brand) {
        this.id = nextId++;
        this.carname = carname;
        this.brand = brand;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
