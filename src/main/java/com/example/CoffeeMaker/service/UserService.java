package com.example.CoffeeMaker.service;
import com.example.CoffeeMaker.model.CoffeeMan;
import com.example.CoffeeMaker.repository.CoffeemanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final CoffeemanRepository coffeemanRepository;

    @Autowired
    public UserService(CoffeemanRepository coffeemanRepository){this.coffeemanRepository=coffeemanRepository}

    //1.Находим всех пользователей кофеварки
    public List<CoffeeMan> findAll(){
        return coffeemanRepository.findAll();
    }

    //2.Включение кофеварки
    //3.Приготовить латте
    public CoffeeMan cookLatte(){

    }
    //4.Приготовить американо
    //5.Приготовить капучино
    //6.Приготовить просто кофе
    //7.Проверка молока
    //8.Выбрать крепость кофе
    //9.Выключение кофеварки

}
