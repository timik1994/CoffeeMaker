package com.example.CoffeeMaker.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoffeeMakerConsumablesAndStatus {
    private Integer volumeWater; //миллилитры
    private Integer volumeMilk; //миллилитры
    private Integer volumeGrains; //граммы
    private Boolean isPower;

    @Override
    public String toString() {
        return "Уровень воды = " + this.volumeWater + " мл\n" +
                "Уровень молока = " + this.volumeMilk + " мл\n" +
                "Количество зерен = " + this.volumeGrains  + " г\n" +
                "Статус кофеварки =" + (this.isPower ? " включена" : " выключена");
    }
}
