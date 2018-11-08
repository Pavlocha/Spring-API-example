package com.mehdi.spring.foodapi.domain;

import javax.persistence.*;

@Entity
public class Food implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String dateProd;
    private String dateExp;
    private int calories;

    @Version
    private int version;

    public Food() {
        super();

    }

    public String getDateProd() {
        return dateProd;
    }

    public void setDateProd(String dateProd) {
        this.dateProd = dateProd;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int getId() {
        return  id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
