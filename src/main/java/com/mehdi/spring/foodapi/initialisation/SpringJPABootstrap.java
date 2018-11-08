package com.mehdi.spring.foodapi.initialisation;

import com.mehdi.spring.foodapi.domain.Food;
import com.mehdi.spring.foodapi.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private FoodService foodService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Food item1 = new Food();
        item1.setName("item1");
        item1.setCalories(700);
        item1.setDateExp("10/20/1998");
        item1.setDateProd("10/01/1990");

        foodService.saveOrUpdate(item1);

        Food item2 = new Food();
        item2.setName("item2");
        item2.setCalories(300);
        item2.setDateExp("09/10/1992");
        item2.setDateProd("02/30/1981");

        foodService.saveOrUpdate(item2);

        Food item3 = new Food();
        item3.setName("item3");
        item3.setCalories(740);
        item3.setDateExp("10/20/1980");
        item3.setDateProd("10/01/1927");

        foodService.saveOrUpdate(item3);
    }
}
