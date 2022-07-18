package com.example.CoffeeMaker.service;

import com.example.CoffeeMaker.enums.StrengthOfCoffee;
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
    void coffeeStrength(StrengthOfCoffee strengthOfCoffee);

    /**Выбрать тип кофе**/
    void CoffeeType(TypeOfCoffeeDrink typeOfCoffeeDrink);

    /**Приготовить кофе**/
    void makeCoffee();

    /**Проверить включена ли кофеварка**/
    Boolean checkTurnOn();

    /**Включить кофеварку**/
    void powerOn();

    /**Выключить кофеварку**/
    void powerOff();
}
