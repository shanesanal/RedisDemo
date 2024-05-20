package com.shane.redisdemo.services;

import com.shane.redisdemo.models.Car;
import com.shane.redisdemo.repositories.CarRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).get();

    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car createCar(String company, String model) {
        Car car = new Car();
        car.setCompany(company);
        car.setModel(model);
        carRepository.save(car);
        return car;
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
