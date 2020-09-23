package ru.study.lesson.spring.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class Tovar {

    private String name;
    private int price;
    @Autowired
    private User user;

    public Tovar() {
    }

    public Tovar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
