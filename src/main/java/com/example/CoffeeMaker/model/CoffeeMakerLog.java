package com.example.CoffeeMaker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "coffeemaker_log")

public class CoffeeMakerLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name="name_of_coffee")
    private String nameOfCoffee;

    @Column(name="consumer_grains")
    private Integer consumerGrains;

    @Column(name="consumer_water")
    private Integer consumerWater;

    @Column(name="consumer_milk")
    private Integer consumerMilk;

    @Column(name="coffee_strength")
    private Integer coffeeStrength;

    @Column(name="operation_name")
    private String operationName;
}
