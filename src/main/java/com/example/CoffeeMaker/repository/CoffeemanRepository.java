package com.example.CoffeeMaker.repository;

import com.example.CoffeeMaker.model.CoffeeMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CoffeemanRepository extends JpaRepository<CoffeeMan, Integer> {
   @Query(value = "INSERT INTO x. public.coffeemaker ", nativeQuery = true)
    List<CoffeeMan> createNewSession(@Param("id") int id, @Param("name") String name, @Param("dt")Date dt);
}
