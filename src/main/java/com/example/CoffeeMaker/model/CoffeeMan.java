package com.example.CoffeeMaker.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "coffeeman")

public class CoffeeMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id в базе.

    @Column(name="name")
    private String name; // имя пользователя

    @Column(name = "time")
    private Date time; // время запуска

    @Column(name = "coffee")
    private String coffee; // тип кофе

    @Column(name="strength")
    private int strength; // крепость кофе

}
