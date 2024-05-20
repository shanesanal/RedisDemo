package com.shane.redisdemo.repositories;

import com.shane.redisdemo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car, Long>{

}
