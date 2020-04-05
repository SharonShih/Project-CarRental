package com.example.demo_car_rental;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class car_controller {

    @GetMapping("/car_renting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Top Car Deals in web") String name, Model model) {
        model.addAttribute("name", name);
        return "home_page";
    }

}
