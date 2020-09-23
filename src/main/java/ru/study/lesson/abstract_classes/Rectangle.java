package ru.study.lesson.abstract_classes;

public class Rectangle extends Shape {
    int a,b;
    public Rectangle(String name) {
        super(name);
    }

    @Override
    public int getSquare() {
        return a*b;
    }

    @Override
    public int getPerimetr() {
        return 0;
    }
}
