package com.example.demo_car_rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.service.CarService;
import com.example.demo_car_rental.service.CustomerService;
import com.example.demo_car_rental.service.RentDateService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Car_controller {
    private CarService carService;
    private RentDateService rentDateService;
    private CustomerService customerService;
    
    @Autowired
    public Car_controller(CarService carService, RentDateService rentDateService, CustomerService customerService){
        this.carService = carService;
        this.rentDateService = rentDateService;
        this.customerService = customerService;
    }
    
    @GetMapping("/home")
    public String home(Model model) {
    	List<Car> cars = (List<Car>) carService.findAll();
    	model.addAttribute("cars", cars);
        return "home_page";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome_page";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login_page";
    }
    
    @GetMapping("/singup")
    public String singup() {
        return "singup_page";
    }
    
    @GetMapping("/booking")
    public String booking() {
        return "booking_page";
    }
}
