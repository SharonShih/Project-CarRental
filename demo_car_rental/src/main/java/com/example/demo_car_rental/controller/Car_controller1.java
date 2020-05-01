package com.example.demo_car_rental.controller;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.model.Customer;
import com.example.demo_car_rental.model.RentDate;
import com.example.demo_car_rental.service.CarService;
import com.example.demo_car_rental.service.CustomerService;
import com.example.demo_car_rental.service.RentDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.List;


@RestController
@SessionAttributes(value = {"customer", "rentDate"})
public class Car_controller1 {

    @Autowired
    private CarService carService;
    @Autowired
    private RentDateService rentDateService;
    @Autowired
    private CustomerService customerService;

    public Car_controller1(CarService carService, RentDateService rentDateService, CustomerService customerService){
        this.carService = carService;
        this.rentDateService = rentDateService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/bookPartOne{car_id}", method = RequestMethod.GET)
    public String checkDates(Model model, @RequestParam(value = "car_id") Long CarId,
                             @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false)
                             @DateTimeFormat(pattern = "yyyy-MM-dd")Calendar startDate, @RequestParam(value = "end_date", defaultValue = "3000-01-01",
                            required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate){
        Car carById = carService.findById(CarId);

        List<AvailableCar> availableCarById = rentDateService.checkAvailableCarById(startDate, endDate, CarId);
        model.addAttribute("carById", carById);
        model.addAttribute("availableCarById", availableCarById);
        return "bookPartOne";
    }

    @RequestMapping(value = "/bookPartOne", method = RequestMethod.POST)
    public String createNewCustomer(Car car, Customer customer, RentDate rentDate, RedirectAttributes redirectAttributes
    , @RequestParam(value = "car_id") Long CarId, @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false)
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")Calendar startDate, @RequestParam(value = "end_date",defaultValue = "3000-01-01",
    required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate){

        car = carService.findById(CarId);
        //customer.getCars().add(car);
        //customer.setRentCars(customer.getRentCars() + 1);
        //customer.setTotalPrice(customer.getTotalPrice());
        rentDate.setCar(car);
        rentDate.setStartDate(startDate);
        rentDate.setEndDate(endDate);
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookPartTwo";
    }


/*
    @GetMapping("/car_renting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Top Car Deals in web") String name, Model model) {
        model.addAttribute("name", name);
        return "home_page";
    }*/

}
