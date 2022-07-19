package com.example.CoffeeMaker.controller;

import com.example.CoffeeMaker.enums.StrengthOfCoffee;
import com.example.CoffeeMaker.enums.TypeOfCoffeeDrink;
import com.example.CoffeeMaker.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMakerController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeMakerController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping(value = "/coffeeMaker/powerON")
    @Operation(tags = "01. Включить кофеварку")
    public String coffeeMakerOn() {
        coffeeService.powerOn();
        return coffeeService.checkTurnOn() ? "Кофеварка включена" : "Кофеварка выключена";
    }

    @GetMapping(value = "/coffeeMaker/powerOff")
    @Operation(tags = "02. Выключить кофеварку")
    public String coffeeMakerOff() {
        coffeeService.powerOff();
        return coffeeService.checkTurnOn() ? "Кофеварка включена" : "Кофеварка выключена";
    }


    @GetMapping(value = "/coffeeMaker/getWaterLevel")
    @Operation(tags = "03. Проверить уровень воды")
    public String checkWaterLevel() {
        int lastWaterLevel=coffeeService.getWaterLevel();
        return coffeeService.checkWaterLevel() ? ("Воды достаточно: " + lastWaterLevel + " мл") : ("Воды не хватает: " + lastWaterLevel + " мл");
    }

    @GetMapping(value = "/coffeeMaker/refillWater")
    @Operation(tags = "04. Долить воду")
    public String refillWater() {
        return coffeeService.refillWater();
    }

    @GetMapping(value = "/coffeeMaker/getMilkLevel")
    @Operation(tags = "05. Проверить уровень молока")
    public String checkMilkLevel() {
        int lastMilkLevel=coffeeService.getWaterLevel();
        return coffeeService.checkMilkLevel() ? ("Молока достаточно: " + lastMilkLevel + " мл") : ("Молока не хватает: " + lastMilkLevel + " мл");
    }

    @GetMapping(value = "/coffeeMaker/refillMilk")
    @Operation(tags = "06. Долить молока")
    public String refillMilk() {
        return coffeeService.refillMilk();
    }

    @GetMapping(value = "/coffeeMaker/getGrainsLevel")
    @Operation(tags = "07. Проверить количество зерен")
    public String checkGrainsLevel() {
        int lastGrainsLevel=coffeeService.getGrainsLevel();
        return coffeeService.checkGrainsLevel() ? ("Зерен достаточно: " + lastGrainsLevel +" г") : ("Зерен не хватает: " + lastGrainsLevel + " г");
    }

    @GetMapping(value = "/coffeeMaker/refillGrains")
    @Operation(tags = "08. Досыпать зерен")
    public String refillGrains() {
        return coffeeService.refillGrains();
    }

    @PostMapping(value = "/coffeeMaker/makeCoffee")
    @Operation(tags = "09. Сварить кофе")
    public String makeCoffee(StrengthOfCoffee strengthOfCoffee, TypeOfCoffeeDrink typeOfCoffeeDrink) {
        return coffeeService.makeCoffee(typeOfCoffeeDrink,strengthOfCoffee);
    }
}
