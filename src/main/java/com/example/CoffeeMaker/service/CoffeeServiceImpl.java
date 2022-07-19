package com.example.CoffeeMaker.service;

import com.example.CoffeeMaker.enums.StrengthOfCoffee;
import com.example.CoffeeMaker.enums.TypeOfCoffeeDrink;
import com.example.CoffeeMaker.model.CoffeeMakerLog;
import com.example.CoffeeMaker.object.CoffeeMakerConsumablesAndStatus;
import com.example.CoffeeMaker.repository.CoffeeMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeMakerRepository coffeeMakerRepository;
    private static CoffeeMakerConsumablesAndStatus coffeeMakerConsumablesAndStatus =
            new CoffeeMakerConsumablesAndStatus(1000, 1000, 1000, false);

    @Autowired
    public CoffeeServiceImpl(CoffeeMakerRepository coffeeMakerRepository) {
        this.coffeeMakerRepository = coffeeMakerRepository;
    }

    @Override
    public Integer getWaterLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeWater();
    }

    @Override
    public Boolean checkWaterLevel() {
        saveLog(null, null, "Проверка уровня воды. Вода на уровне: " + coffeeMakerConsumablesAndStatus.getVolumeWater() + " мл");
        return coffeeMakerConsumablesAndStatus.getVolumeWater() > 50;
    }

    @Override
    public String refillWater() {
        String message;
        if (coffeeMakerConsumablesAndStatus.getVolumeWater() < 1000) {
            coffeeMakerConsumablesAndStatus.setVolumeWater(1000);
            message = "Вода заполнена до отметки: 1000 мл";
            saveLog(null, null, message);
            return message;
        }
        message = "Вода уже заполнена до максимума!";
        saveLog(null, null, message);
        return message;
    }

    @Override
    public Integer getGrainsLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeGrains();
    }

    @Override
    public Boolean checkGrainsLevel() {
        saveLog(null, null, "Проверка уровня зерен. Зерна на уровне: " + coffeeMakerConsumablesAndStatus.getVolumeGrains() + " г");
        return coffeeMakerConsumablesAndStatus.getVolumeGrains() > 50;
    }

    @Override
    public String refillGrains() {
        String message;
        if (coffeeMakerConsumablesAndStatus.getVolumeGrains() < 1000) {
            coffeeMakerConsumablesAndStatus.setVolumeGrains(1000);
            message = "Зерна заполнены до отметки: 1000 г";
            saveLog(null, null, message);
            return message;
        }

        message = "Зерна уже заполнены до максимума!";
        saveLog(null, null, message);
        return message;
    }


    @Override
    public Integer getMilkLevel() {
        return coffeeMakerConsumablesAndStatus.getVolumeMilk();
    }

    @Override
    public Boolean checkMilkLevel() {
        saveLog(null, null, "Проверка уровня молока. Молоко на уровне: " + coffeeMakerConsumablesAndStatus.getVolumeMilk());
        return coffeeMakerConsumablesAndStatus.getVolumeMilk() > 50;
    }

    @Override
    public String refillMilk() {
        String message;
        if (coffeeMakerConsumablesAndStatus.getVolumeMilk() < 1000) {
            coffeeMakerConsumablesAndStatus.setVolumeMilk(1000);
            message = "Молоко заполнено до отметки: 1000 мл";
            saveLog(null, null, message);
            return message;
        }
        message = "Молоко уже заполнено до максимума!";
        saveLog(null, null, message);
        return message;
    }

    @Override
    public String makeCoffee(TypeOfCoffeeDrink typeOfCoffeeDrink, StrengthOfCoffee strengthOfCoffee) {

        int grain = typeOfCoffeeDrink.getConsumerGrains() * strengthOfCoffee.getStrength();
        int water = typeOfCoffeeDrink.getConsumerWater();
        int milk = typeOfCoffeeDrink.getConsumerMilk();

        if (coffeeMakerConsumablesAndStatus.getVolumeWater() < water) {
            String error = "Сварить кофе не удалось, низкий уровень воды: " + coffeeMakerConsumablesAndStatus.getVolumeWater() + " мл";
            saveLog(typeOfCoffeeDrink, strengthOfCoffee, error);
            return error;
        }

        if (coffeeMakerConsumablesAndStatus.getVolumeMilk() < milk) {
            String error = "Сварить кофе не удалось, низкий уровень молока: " + coffeeMakerConsumablesAndStatus.getVolumeMilk() + " мл";
            saveLog(typeOfCoffeeDrink, strengthOfCoffee, error);
            return error;
        }

        if (coffeeMakerConsumablesAndStatus.getVolumeGrains() < grain) {
            String error = "Сварить кофе не удалось, низкий уровень зерен: " + coffeeMakerConsumablesAndStatus.getVolumeGrains() + " г";
            saveLog(typeOfCoffeeDrink, strengthOfCoffee, error);
            return error;
        }

        if (!coffeeMakerConsumablesAndStatus.getIsPower()) {
            String error = "Сварить кофе не удалось, кофеварка выключена";
            saveLog(typeOfCoffeeDrink, strengthOfCoffee, error);
            return error;
        }

        whiteOffConsumables(typeOfCoffeeDrink, strengthOfCoffee);
        saveLog(typeOfCoffeeDrink, strengthOfCoffee, "Варим кофе " + typeOfCoffeeDrink.getNameCoffeeDrink());
        String success = "Кофе " + typeOfCoffeeDrink.getNameCoffeeDrink() + " успешно сварен ! \n" + coffeeMakerConsumablesAndStatus;
        return success;
    }


    @Override
    public Boolean checkTurnOn() {
        return coffeeMakerConsumablesAndStatus.getIsPower();
    }

    @Override
    public void powerOn() {
        coffeeMakerConsumablesAndStatus.setIsPower(true);
        saveLog(null, null, "Включение кофеварки");
    }

    @Override
    public void powerOff() {
        coffeeMakerConsumablesAndStatus.setIsPower(false);
        saveLog(null, null, "Выключение кофеварки");
    }

    private void saveLog(TypeOfCoffeeDrink typeOfCoffeeDrink, StrengthOfCoffee strengthOfCoffee, String message) {

        CoffeeMakerLog coffeeMakerLog = new CoffeeMakerLog();
        coffeeMakerLog.setDateTime(new Date());
        coffeeMakerLog.setOperationName(message);

        if (typeOfCoffeeDrink == null && strengthOfCoffee == null) {
            coffeeMakerRepository.save(coffeeMakerLog);
            return;
        }

        int grain = typeOfCoffeeDrink.getConsumerGrains() * strengthOfCoffee.getStrength();
        int water = typeOfCoffeeDrink.getConsumerWater();
        int milk = typeOfCoffeeDrink.getConsumerMilk();

        coffeeMakerLog.setNameOfCoffee(typeOfCoffeeDrink.getNameCoffeeDrink());
        coffeeMakerLog.setCoffeeStrength(strengthOfCoffee.getStrength());
        coffeeMakerLog.setConsumerGrains(grain);
        coffeeMakerLog.setConsumerMilk(milk);
        coffeeMakerLog.setConsumerWater(water);

        coffeeMakerRepository.save(coffeeMakerLog);
    }

    private void whiteOffConsumables(TypeOfCoffeeDrink typeOfCoffeeDrink, StrengthOfCoffee strengthOfCoffee) {
        int grains = typeOfCoffeeDrink.getConsumerGrains() * strengthOfCoffee.getStrength();
        int water = typeOfCoffeeDrink.getConsumerWater();
        int milk = typeOfCoffeeDrink.getConsumerMilk();

        coffeeMakerConsumablesAndStatus.setVolumeGrains(coffeeMakerConsumablesAndStatus.getVolumeGrains() - grains);
        coffeeMakerConsumablesAndStatus.setVolumeMilk(coffeeMakerConsumablesAndStatus.getVolumeMilk() - milk);
        coffeeMakerConsumablesAndStatus.setVolumeWater(coffeeMakerConsumablesAndStatus.getVolumeWater() - water);

        System.out.println("Списались расходники!");
        System.out.println(coffeeMakerConsumablesAndStatus);
    }
}
