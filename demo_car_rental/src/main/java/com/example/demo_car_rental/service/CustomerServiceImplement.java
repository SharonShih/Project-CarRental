package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.Customer;
import com.example.demo_car_rental.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplement implements CustomerService{


    private CustomerDAO customerDAO;

    public CustomerServiceImplement(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.customerDAO.save(customer);
    }
}
