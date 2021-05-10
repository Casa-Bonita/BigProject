package ru.study.homework.addition_theme.Collections.task3;

import java.util.ArrayList;
import java.util.Random;

public class Client {
//    Создать класс Client с private полями:
//    - tableNumber; //номер столика
//    - ArrayList<Dish> orders = new ArrayList(); //список заказов
//    Переопределить метод toString.
//    Остальную структуру класса Client дополнить самостоятельно по необходимости.

    private int tableNumber;
    private ArrayList<Dish> orders;

    public Client() {
    }

    public Client(int tableNumber, ArrayList<Dish> orders) {
        this.tableNumber = tableNumber;
        this.orders = orders;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public ArrayList<Dish> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Dish> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "tableNumber = " + tableNumber + ", orders = " + orders;
    }
}
