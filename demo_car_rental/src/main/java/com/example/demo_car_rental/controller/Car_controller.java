package com.example.demo_car_rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo_car_rental.model.Car;
import com.example.demo_car_rental.model.Customer;
import com.example.demo_car_rental.service.CarService;
import com.example.demo_car_rental.service.CustomerService;
import com.example.demo_car_rental.service.RentDateService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

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
    //public String home(Model model) {
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Customer customer = customerService.findByUsername(auth.getName());
    	List<Car> cars = (List<Car>) carService.findAll();
    	modelAndView.addObject("cars", cars);
    	modelAndView.addObject("name", auth.getName());
    	modelAndView.setViewName("home_page");
    	//model.addAttribute("cars", cars);
        return modelAndView;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome_page";
    }
    
    @GetMapping("/booking")
    @ResponseBody
    public ModelAndView booking(@RequestParam Long id) {
    	ModelAndView modelAndView = new ModelAndView();
        Car car = carService.findById(id);
        modelAndView.addObject("car", car);
    	modelAndView.setViewName("booking_page");
        return modelAndView;
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login_page");
        return modelAndView;
    }
    
    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("signup_page");
        return modelAndView;
    }
    
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        Customer customerExists = customerService.findByUsername(customer.getUsername());
        if (customerExists == null) {
        	customerService.save(customer);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("customer", new Customer());
            modelAndView.setViewName("signup_page");

        }
        return modelAndView;
    }
}
