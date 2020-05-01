package com.example.demo_car_rental.controller;

import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class CarDetail {

    @Autowired
    private CarService carService;

    public CarDetail(CarService carService){
        this.carService = carService;
    }

    @RequestMapping(value = "/carDetail{car_id}", method = RequestMethod.GET)
    public String carDetail(Model model, @RequestParam(value = "car_id") Long carId){
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "carDetail";
    }
}
