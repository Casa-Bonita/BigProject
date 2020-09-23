package ru.study.lesson.json.ex1;

public class Tovar {
    String tovarName;
    int price;

    public Tovar(String tovarName, int price) {
        this.tovarName = tovarName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "name='" + tovarName + '\'' +
                ", price=" + price +
                '}';
    }
}
