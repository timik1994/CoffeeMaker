package com.example.CoffeeMaker.enums;

import lombok.Getter;

@Getter
public enum TypeOfCoffeeDrink {
    LATTE("LATTE", 50, 60, 60),
    CAPPUCCINO("CAPPUCCINO", 40, 50, 70),
    ESPRESSO("ESPRESSO", 30, 0, 0),
    AMERICANO("AMERICANO",30,0,100),
    BLACK_COFFEE("BLACK_COFFEE",50,0,200);

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
