package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.Rent;
import com.example.demo_car_rental.repository.RentDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImplement implements RentService {

    private RentDAO rentDAO;

    public RentServiceImplement(RentDAO rentDAO){
        this.rentDAO = rentDAO;
    }

    @Override
    public Rent findByCustomerId(Long id){
        return this.rentDAO.findByCustomerId(id);
    }

    @Override
    public Rent findByCarId(Long id){
        return this.rentDAO.findByCarId(id);
    }

    @Override
    public List<Rent> findAll(){
        return this.rentDAO.findAll();
    }

    @Override
    public void save(Rent rent){
        this.rentDAO.save(rent);
    }

}
