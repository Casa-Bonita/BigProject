package ru.study.lesson.hibernate.ex2_relation.one_to_one;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    @OneToOne
    @JoinColumn(name = "gosnumber_id")
    private GosNumber gosNumber;

    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public GosNumber getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(GosNumber gosNumber) {
        this.gosNumber = gosNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
