package com.example.CoffeeMaker.service;

import com.example.CoffeeMaker.enums.TypeOfCoffeeDrink;

public interface CoffeeService {

    /**Проверить уровень воды**/
    Integer getWaterLevel();
    Boolean checkWaterLevel();

    /**Залить воду*/
    void refillWater();

    /**Проверить наличие зерен**/
    Integer getGrainsLevel();
    Boolean checkGrainsLevel();
    /**Засыпать зерна*/
    void refillGrains();

    /**Проверить наличие молока**/
    Integer getMilkLevel();
    Boolean checkMilkLevel();
    /**Залить молоко**/
    void refillMilk();

    /**Выбрать крепость кофе**/
    void coffeeStrength(Integer coffeeStrength);

    /**Приготовить кофе**/
    void CoffeeType(TypeOfCoffeeDrink typeOfCoffeeDrink);
    void makeCoffee();

    /**Проверить включена ли кофеварка**/
    Boolean checkTurnOn();
    void powerOn();
    void powerOff();
}
