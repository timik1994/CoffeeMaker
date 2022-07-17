package com.example.CoffeeMaker.enums;

import lombok.Getter;

@Getter
public enum TypeOfCoffeeDrink {
    LATTE("LATTE", 50, 60, 60),
    CAPPUCCINO("CAPPUCCINO", 40, 50, 70),
    ESPRESSO("ESPRESSO", 50, 0, 30);

    private String nameCoffeeDrink;
    private Integer consumerGrains;
    private Integer consumerMilk;
    private Integer consumerWater;

    TypeOfCoffeeDrink(String nameCoffeeDrink, Integer consumerGrains, Integer consumerMilk, Integer consumerWater){
        this.nameCoffeeDrink=nameCoffeeDrink;
        this.consumerGrains=consumerGrains;
        this.consumerMilk=consumerMilk;
        this.consumerWater=consumerWater;
    }
}
