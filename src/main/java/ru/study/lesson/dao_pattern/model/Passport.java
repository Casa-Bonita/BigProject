package ru.study.lesson.dao_pattern.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seria;
    private int number;

    public Passport() {

    }

    public Passport(int id, int seria, int number) {
        this.id = id;
        this.seria = seria;
        this.number = number;
    }

    public int getSeria() {
        return seria;
    }

    public void setSeria(int seria) {
        this.seria = seria;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "seria=" + seria +
                ", number=" + number +
                '}';
    }
}
