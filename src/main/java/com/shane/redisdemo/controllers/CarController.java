package com.shane.redisdemo.controllers;

import com.shane.redisdemo.models.Car;
import com.shane.redisdemo.services.CarService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("{id}")
    @Cacheable (value = "car")
    public Car getCar(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/")
    @Cacheable (value = "car")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @PostMapping("/create")
   // @Cacheable (key ="#car.id", value = "car")
    @CachePut (value = "car")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car.getCompany(), car.getModel());
    }

    @DeleteMapping("/")
    public void deleteAllCars() {
        carService.deleteAllCars();
    }
}
