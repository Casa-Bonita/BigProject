package ru.study.homework.java8.task3;

public class Book {
    private int price;
    private String name;
    private String author;

    public Book(int price, String name, String author) {
        this.price = price;
        this.name = name;
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
