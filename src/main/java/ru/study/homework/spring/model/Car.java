package ru.study.homework.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String autoMaker;
    private String model;
    private int price;

    public Car() {
    }

    public Car(int id, String autoMaker, String model, int price) {
        this.id = id;
        this.autoMaker = autoMaker;
        this.model = model;
        this.price = price;
    }
    public Car(String autoMaker, String model, int price) {
        this(0, autoMaker, model, price);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(autoMaker, car.autoMaker) &&
                Objects.equals(model, car.model);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoMaker() {
        return autoMaker;
    }

    public void setAutoMaker(String autoMaker) {
        this.autoMaker = autoMaker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", autoMaker='" + autoMaker + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
