package com.example.demo_car_rental.controller;

import com.example.demo_car_rental.model.RentDate;
import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.model.Customer;
import com.example.demo_car_rental.service.CarService;
import com.example.demo_car_rental.service.RentDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes(value = {"customer", "rentDate"})
public class Car_controller3 {

    @Autowired
    private CarService carService;
    @Autowired
    private RentDateService rentDateService;

    public Car_controller3(CarService carService, RentDateService rentDateService){
        this.carService = carService;
        this.rentDateService = rentDateService;
    }

    @RequestMapping(value = "bookPartThree{car_id}", method = RequestMethod.GET)
    public String showSessionCar(Model model, @RequestParam(value = "car_id") Long carId){
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "bookPartThree";
    }

}
