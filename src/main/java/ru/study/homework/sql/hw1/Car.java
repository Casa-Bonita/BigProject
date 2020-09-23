package ru.study.homework.sql.hw1;

public class Car {
    private String automaker;
    private String model;
    private int amount;

    public Car (String automaker, String model, int amount){
        this.automaker = automaker;
        this.model = model;
        this.amount = amount;
    }

    public String getAutomaker() {
        return automaker;
    }

    public String getModel() {
        return model;
    }

    public int getAmount() {
        return amount;
    }
}
