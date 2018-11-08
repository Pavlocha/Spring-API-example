package com.mehdi.spring.foodapi.controllers;

import com.mehdi.spring.foodapi.domain.Food;
import com.mehdi.spring.foodapi.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping("/")
    @ResponseBody
    public String Welcome() {
        return "Welcome to FoodAPI";
    }

    @GetMapping("/foods")
    @ResponseBody
    public List<Food> listFoods(){
        return foodService.listALL();
    }

    @GetMapping("/foods/calories")
    @ResponseBody
    public long getAllCalories() {
        return foodService.getSumCalories();
    }


    @GetMapping("/food/{id}")
    @ResponseBody
    public Food getfood(@PathVariable int id) {
        return (Food) foodService.getByID(id);
    }

    @PostMapping("/food")
    @ResponseBody
    public void updatefood(@RequestBody Food food) {
        foodService.saveOrUpdate(food);
    }

    @DeleteMapping("/food/{id}")
    @ResponseBody
    public void deleteFood(@PathVariable int id) {
        foodService.delete(id);
    }
}
