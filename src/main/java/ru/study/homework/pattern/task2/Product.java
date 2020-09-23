package ru.study.homework.pattern.task2;

public class Product {
    private String name;
    private double price;
    private int stockBalance;

    public Product(String name, double price, int stockBalance) {
        this.name = name;
        this.price = price;
        this.stockBalance = stockBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBalanceAtPlant() {
        return stockBalance;
    }

    public void setBalanceAtPlant(int balanceAtPlant) {
        this.stockBalance = balanceAtPlant;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", balanceAtPlant=" + stockBalance +
                '}';
    }
}
