package com.example.CoffeeMaker.enums;

import lombok.Getter;

@Getter
public enum StrengthOfCoffee {
    LOW(1),
    MEDIUM(2),
    HARD(3);

    private Integer strength;

    StrengthOfCoffee(Integer strength){
        this.strength=strength;
    }
}
