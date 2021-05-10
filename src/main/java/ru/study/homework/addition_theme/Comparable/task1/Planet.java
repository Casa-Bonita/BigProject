package ru.study.homework.addition_theme.Comparable.task1;

public class Planet{
//    Создать класс Planet с полями:
//    - название;
//    - диаметр (дробное число).

    private String name;
    private double diameter;

    public Planet(String name, double diameter) {
        this.name = name;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

}