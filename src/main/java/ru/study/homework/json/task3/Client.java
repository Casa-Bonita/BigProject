package ru.study.homework.json.task3;

import java.util.List;

public class Client {
    private String name;
    private String surname;
    private String birthDate;
    List<Card> list;

    public Client (String name, String surname, String birthDate, List<Card> list){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", list=" + list +
                '}';
    }
}
