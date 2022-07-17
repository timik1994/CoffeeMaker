package com.example.CoffeeMaker.service;

import com.example.CoffeeMaker.enums.TypeOfCoffeeDrink;
import com.example.CoffeeMaker.object.CoffeeMakerConsumablesAndStatus;
import com.example.CoffeeMaker.repository.CoffeemanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeemanRepository coffeemanRepository;
    private static CoffeeMakerConsumablesAndStatus coffeeMakerConsumablesAndStatus =
            new CoffeeMakerConsumablesAndStatus(1000, 1000, 1000, false);


    @Autowired
    public CoffeeServiceImpl(CoffeemanRepository coffeemanRepository) {
        this.coffeemanRepository = coffeemanRepository;
    }


    @Override
    public Integer getWaterLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeWater();
    }

    //TODO think
    @Override
    public Boolean checkWaterLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeWater() > 50;
    }

    @Override
    public void refillWater() {
        coffeeMakerConsumablesAndStatus.setVolumeWater(1000);
    }

    @Override
    public Integer getGrainsLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeGrains();
    }

    @Override
    public Boolean checkGrainsLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeGrains() > 50;
    }

    @Override
    public void refillGrains() {
        coffeeMakerConsumablesAndStatus.setVolumeGrains(1000);
    }

    @Override
    public Integer getMilkLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeMilk();
    }

    @Override
    public Boolean checkMilkLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeMilk() > 50;
    }

    @Override
    public void refillMilk() {
        coffeeMakerConsumablesAndStatus.setVolumeMilk(1000);
    }

    @Override
    public void coffeeStrength(Integer coffeeStrength) {
    }

    @Override
    public void CoffeeType(TypeOfCoffeeDrink typeOfCoffeeDrink) {
    }

    @Override
    public void makeCoffee() {
    }

    @Override
    public Boolean checkTurnOn() {
        return coffeeMakerConsumablesAndStatus.getIsPower();
    }

    @Override
    public void powerOn() {
        coffeeMakerConsumablesAndStatus.setIsPower(true);
    }

    @Override
    public void powerOff() {
        coffeeMakerConsumablesAndStatus.setIsPower(false);
    }
}
