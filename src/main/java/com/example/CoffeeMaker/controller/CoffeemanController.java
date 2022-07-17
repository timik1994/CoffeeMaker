package com.example.CoffeeMaker.controller;


import com.example.CoffeeMaker.model.CoffeeMan;
import com.example.CoffeeMaker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller  //RestController
public class CoffeemanController {

    private final UserService userService;

    @Autowired
    public CoffeemanController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/students";
    }

    // Информацию будем дергать не из репозитория а из UserService- так правильно.!
    @GetMapping("/coffeeMEN")
    public String findAll(Model model) {
        List<CoffeeMan> coffeeMEN = userService.findAll();
        model.addAttribute("coffeeMEN", coffeeMEN);
        return "coffeeMEN-list";
    }
}
