package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.model.Rent;
import com.example.demo_car_rental.repository.RentDAO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
/*
    @Override
    public List<AvailableCar> checkAvailableCars(Calendar startDate, Calendar endDate){
        return this.rentDAO.checkAvailableCars(startDate, endDate);
    }

    @Override
    public List<AvailableCar> checkAvailableCarById(Calendar startDate, Calendar endDate, Long id) {
        return this.rentDAO.checkAvailableCarById(startDate, endDate, id);
    }
*/
    @Override
    public long countDays(Rent rent){
        long days;
        Calendar start = rent.getStartDate();
        Calendar end = rent.getEndDate();
        days = daysBetween(start, end);
        return days;
    }

    private long daysBetween(Calendar startDate, Calendar endDate){
        endDate.add(Calendar.DATE, 1);
        long end = endDate.getTimeInMillis();
        long start = startDate.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
    }
}
