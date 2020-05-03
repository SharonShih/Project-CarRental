package com.example.demo_car_rental.controller;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class Index {
	/*
    @Autowired
    private RentDateService rentDateService;

    public Index(RentDateService rentDateService){
        this.rentDateService = rentDateService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model,
                 @RequestParam(value = "start_date", defaultValue = "1800-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar startDate,
                 @RequestParam(value = "end_date", defaultValue = "3000-01-01", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Calendar endDate) {
        List<AvailableCar> availableCars = rentDateService.checkAvailableCars(startDate, endDate);
        model.addAttribute("availableCars", availableCars);
        return "index";
    }*/
}
