package ru.study.homework.addition_theme.ENUM;

public class Rectangle {

    private Color color;
    private int a;
    private int b;

    public Rectangle() {
    }

    public Rectangle(Color color, int a, int b) {
        this.color = color;
        this.a = a;
        this.b = b;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "color = " + color + ", a = " + a + ", b = " + b;
    }
}