package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.model.Rent;

import java.util.Calendar;
import java.util.List;


public interface RentService {
	/*
    List<AvailableCar> checkAvailableCarById(Calendar startDate, Calendar endDate, Long carId);

    List<AvailableCar> checkAvailableCars(Calendar startDate, Calendar endDate);*/

    List<Rent> findAll();

    Rent findByCustomerId(Long id);

    Rent findByCarId(Long id);

    void save(Rent rentDate);

    long countDays(Rent rentDate);
}
