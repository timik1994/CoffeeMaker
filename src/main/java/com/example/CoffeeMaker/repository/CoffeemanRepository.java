package com.example.CoffeeMaker.repository;

import com.example.CoffeeMaker.model.CoffeeMakerLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeemanRepository extends JpaRepository<CoffeeMakerLog, Integer> {
}
