package ru.study.lesson.abstract_classes;

public class Triangle extends Shape {
    int a,b,c;

    public Triangle(String name) {
        super(name);
    }

    @Override
    public int getSquare() {
        return a*b*c;
    }
    @Override
    public int getPerimetr() {
        return 0;
    }
}
