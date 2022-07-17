package com.example.CoffeeMaker.repository;

import com.example.CoffeeMaker.model.CoffeeMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoffeemanRepository extends JpaRepository<CoffeeMan, Integer> {
   /* @Query(value = "SELECT x.* FROM public.coffeemaker ", nativeQuery = true)
    List<CoffeeMan> countAllCoffeeMan();*/
}
