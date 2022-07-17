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
        return "Уровень воды = " + this.volumeWater / 10 + "%" +
                "Уровень молока = " + this.volumeMilk / 10 + "%" +
                "Количество зерен = " + this.volumeGrains / 10 + "%" +
                "Статус кофеварки =" + (this.isPower ? "включена" : "выключена");
    }
}
