package com.example.demo_car_rental.controller;


import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.model.Customer;
import com.example.demo_car_rental.model.Rent;
import com.example.demo_car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@SessionAttributes(value = {"customer","rentDate"})
public class Car_controller2 {
    @Autowired
    private CarService carService;

    public Car_controller2(CarService carService){
        this.carService = carService;
    }

    @RequestMapping(value = "bookPartTwo{car_id}", method = RequestMethod.GET)
    public String showSessionCar(Model model, @RequestParam(value = "car_id") Long carId){
        Car carById = carService.findById(carId);
        model.addAttribute("carById", carById);
        return "bookPartTwo";
    }

    @RequestMapping(value = "bookPartTwo", method = RequestMethod.POST)
    public @ResponseBody String completeCustomer(Customer customer, Rent rentDate, RedirectAttributes redirectAttributes,
                                   @RequestParam(value = "car_id") Long CarId){
        redirectAttributes.addAttribute("car_id", CarId);
        return "redirect:/bookPartThree";
    }
}
