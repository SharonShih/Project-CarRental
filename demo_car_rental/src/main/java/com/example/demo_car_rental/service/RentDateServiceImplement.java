package com.example.demo_car_rental.service;

import com.example.demo_car_rental.model.AvailableCar;
import com.example.demo_car_rental.model.RentDate;
import com.example.demo_car_rental.repository.RentDateDAO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RentDateServiceImplement implements RentDateService {

    private RentDateDAO rentDateDAO;

    public RentDateServiceImplement(RentDateDAO rentDateDAO){
        this.rentDateDAO = rentDateDAO;
    }

    @Override
    public RentDate findByCustomerId(Long id){
        return this.rentDateDAO.findByCustomerId(id);
    }

    @Override
    public RentDate findByCarId(Long id){
        return this.rentDateDAO.findByCarId(id);
    }

    @Override
    public List<RentDate> findAll(){
        return this.rentDateDAO.findAll();
    }

    @Override
    public void save(RentDate rentDate){
        this.rentDateDAO.save(rentDate);
    }

    @Override
    public List<AvailableCar> checkAvailableCars(Calendar startDate, Calendar endDate){
        return this.rentDateDAO.checkAvailableCars(startDate, endDate);
    }

    @Override
    public List<AvailableCar> checkAvailableCarById(Calendar startDate, Calendar endDate, Long id) {
        return this.rentDateDAO.checkAvailableCarById(startDate, endDate, id);
    }

    @Override
    public long countDays(RentDate rentDate){
        long days;
        Calendar start = rentDate.getStartDate();
        Calendar end = rentDate.getEndDate();
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
