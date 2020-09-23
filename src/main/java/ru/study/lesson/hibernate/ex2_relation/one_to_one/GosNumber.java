package ru.study.lesson.hibernate.ex2_relation.one_to_one;

import javax.persistence.*;

@Entity
public class GosNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(mappedBy = "gosNumber")
    private Car car;

    public GosNumber() {
    }

    public GosNumber(String number){
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String gosNumber) {
        this.number = gosNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "GosNumber{" +
                "id=" + id +
                ", gosNumber='" + number + '\'' +
                '}';
    }
}
