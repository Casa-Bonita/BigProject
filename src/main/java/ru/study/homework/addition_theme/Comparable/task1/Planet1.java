package ru.study.homework.addition_theme.Comparable.task1;

public class Planet1 implements Comparable<Planet1>{
//    Создать класс Planet с полями:
//    - название;
//    - диаметр (дробное число).

    private String name;
    private double diameter;

    public Planet1(String name, double diameter) {
        this.name = name;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    public int compareTo(Planet1 anotherPlanet){
        if (this.diameter == anotherPlanet.diameter){
            return 0;
        }
        else if(this.diameter > anotherPlanet.diameter){
            return 1;
        }
        else{
            return -1;
        }
    }

}