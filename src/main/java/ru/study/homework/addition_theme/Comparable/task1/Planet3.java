package ru.study.homework.addition_theme.Comparable.task1;

public class Planet3 implements Comparable<Planet3>{
//    Создать класс Planet с полями:
//    - название;
//    - диаметр (дробное число).

    private String name;
    private double diameter;

    public Planet3(String name, double diameter) {
        this.name = name;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    public int compareTo(Planet3 anotherPlanet){
        String name1 = this.getName().toLowerCase();
        String name2 = anotherPlanet.getName().toLowerCase();

        return name1.compareTo(name2);
    }
}