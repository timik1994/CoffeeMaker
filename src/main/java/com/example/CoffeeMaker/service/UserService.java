package com.example.CoffeeMaker.service;
import com.example.CoffeeMaker.model.CoffeeMan;
import com.example.CoffeeMaker.repository.CoffeemanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final CoffeemanRepository coffeemanRepository;

    @Autowired
    public UserService(CoffeemanRepository coffeemanRepository){this.coffeemanRepository=coffeemanRepository;}

    //1.Считываем всех пользователей кофеварки
    public List<CoffeeMan>  readAll(){
        return coffeemanRepository.findAll();
    }

    //2.Включение кофеварки - идет запись в бд id,name,date&time
    public List<CoffeeMan> newSession(int id, String name, Date dt){
        return coffeemanRepository.createNewSession(id, name, dt);
    }
    //3.Проверить уровень воды
    //4.Проверить наличие зерен
    //5.Проверить наличие молока. Если молока нет то возможно сделать только американо и просто кофе
    //6.Выбрать крепость кофе - идет запись в бд в поле strenght записывается цифра крепости: 1/2/3 - завсисит от выбора пользователя
    public CoffeeMan chooseStrength(CoffeeMan strength) {
        return coffeemanRepository.save(strength);
    }
    //7.Приготовить кофе на выбор - латте/капучино/американо/просто кофе - идет запись напитка в бд в поле coffee
    public CoffeeMan cookCoffee(CoffeeMan coffee){
        return coffeemanRepository.save(coffee);
    }

    //8.Предложить еще напиток- если ничего не выбрано - выключить
}
