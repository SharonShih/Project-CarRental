package com.example.demo_car_rental.repository;

import com.example.demo_car_rental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.lang.Long;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarDAO extends JpaRepository<Car, Integer> {


    @Query("from Car as c where c.id not in (select b.car.id from RentDate as b)")
    List<Car> newCars();

    List<Car> findAll();
    Car findById(Long id);
}
