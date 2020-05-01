package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.Car;
import java.util.List;
import java.util.Optional;


public interface CarService {
    List<Car> findAll();

    List<Car> newCars();

    Car findById(Long id);

    void save(Car car);
}
