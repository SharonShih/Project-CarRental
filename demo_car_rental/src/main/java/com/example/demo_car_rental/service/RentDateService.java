package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.model.RentDate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;


public interface RentDateService {
    List<AvailableCar> checkAvailableCarById(Calendar startDate, Calendar endDate, Long carId);

    List<AvailableCar> checkAvailableCars(Calendar startDate, Calendar endDate);

    List<RentDate> findAll();

    RentDate findByCustomerId(Long id);

    RentDate findByCarId(Long id);

    void save(RentDate rentDate);

    long countDays(RentDate rentDate);
}
