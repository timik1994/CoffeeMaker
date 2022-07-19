package com.example.CoffeeMaker.service;

import com.example.CoffeeMaker.enums.StrengthOfCoffee;
import com.example.CoffeeMaker.enums.TypeOfCoffeeDrink;

public interface CoffeeService {

    /**Проверить уровень воды**/
    Integer getWaterLevel();
    Boolean checkWaterLevel();

    /**Залить воду*/
    String refillWater();

    /**Проверить наличие зерен**/
    Integer getGrainsLevel();
    Boolean checkGrainsLevel();

    /**Засыпать зерна*/
    String refillGrains();

    /**Проверить наличие молока**/
    Integer getMilkLevel();
    Boolean checkMilkLevel();

    /**Залить молоко**/
    String refillMilk();

    /**Приготовить кофе**/
    String makeCoffee(TypeOfCoffeeDrink typeOfCoffeeDrink, StrengthOfCoffee strengthOfCoffee);

    /**Проверить включена ли кофеварка**/
    Boolean checkTurnOn();

    /**Включить кофеварку**/
    void powerOn();

    /**Выключить кофеварку**/
    void powerOff();
}
