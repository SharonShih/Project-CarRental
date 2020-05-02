package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Long id);
    
    Customer findByUsername(String username);

    Customer save(Customer customer);
}
