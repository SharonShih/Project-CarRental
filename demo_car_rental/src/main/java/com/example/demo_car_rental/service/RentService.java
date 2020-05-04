package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.Rent;

import java.util.List;


public interface RentService {

    List<Rent> findAll();

    Rent findByCustomerId(Long id);

    Rent findByCarId(Long id);

    void save(Rent rent);
}
