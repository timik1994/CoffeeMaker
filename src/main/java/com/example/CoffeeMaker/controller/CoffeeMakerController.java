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
        return coffeeService.checkWaterLevel() ? "Воды достаточно" : "Воды не хватает";
    }

    @GetMapping(value = "/coffeeMaker/refillWater")
    @Operation(tags = "04. Долить воду")
    public String refillWater() {
        coffeeService.refillWater();
        return coffeeService.checkWaterLevel() ? "Воды достаточно" : "Воды не хватает";
    }

    @GetMapping(value = "/coffeeMaker/getMilkLevel")
    @Operation(tags = "05. Проверить уровень молока")
    public String checkMilkLevel() {
        return coffeeService.checkMilkLevel() ? "Молока достаточно" : "Молока не хватает";
    }

    @GetMapping(value = "/coffeeMaker/refillMilk")
    @Operation(tags = "06. Долить молока")
    public String refillMilk() {
        coffeeService.refillMilk();
        return coffeeService.checkMilkLevel() ? "Молока достаточно" : "Молока не хватает";
    }

    @GetMapping(value = "/coffeeMaker/getGrainsLevel")
    @Operation(tags = "07. Проверить количество зерен")
    public String checkGrainsLevel() {
        return coffeeService.checkGrainsLevel() ? "Зерен достаточно" : "Зерен не хватает";
    }

    @GetMapping(value = "/coffeeMaker/refillGrains")
    @Operation(tags = "08. Досыпать зерен")
    public String refillGrains() {
        coffeeService.refillGrains();
        return coffeeService.checkGrainsLevel() ? "Зерен достаточно" : "Зерен не хватает";
    }

    @PostMapping(value = "/coffeeMaker/selectedCoffeeStrength")
    @Operation(tags = "09. Выбрать крепость кофе")
    public String selectedCoffeeStrength(StrengthOfCoffee strengthOfCoffee) {
        coffeeService.coffeeStrength(strengthOfCoffee);
        return "Установлена крепость кофе = " + strengthOfCoffee;
    }


    @PostMapping(value = "/coffeeMaker/selectedCoffeeType")
    @Operation(tags = "10. Выбрать кофе")
    public String selectedCoffeeType(TypeOfCoffeeDrink typeOfCoffeeDrink) {
        coffeeService.CoffeeType(typeOfCoffeeDrink);
        return "Выбрано кофе: " + typeOfCoffeeDrink;
    }

    @GetMapping(value = "/coffeeMaker/makeCoffee")
    @Operation(tags = "11. Сварить кофе")
    public String makeCoffee() {
        coffeeService.makeCoffee();
        return "Кофе готов. Приятного кофепития!";
    }
}
