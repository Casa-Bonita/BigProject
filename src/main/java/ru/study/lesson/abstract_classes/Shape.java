package ru.study.lesson.abstract_classes;

public abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract int getSquare();

    public abstract int getPerimetr();
}
