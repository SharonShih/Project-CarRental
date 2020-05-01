package com.example.demo_car_rental.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AvailableCar implements Serializable {
    private static final long serialVersionUID = 3209915747110932732L;

    public AvailableCar(int id, int carId, String carName, int carPrice) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.carPrice = carPrice;
    }

    private int id;
    private int carId;
    private String carName;
    private int carPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }
}
