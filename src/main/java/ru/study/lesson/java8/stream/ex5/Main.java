package ru.study.lesson.java8.stream.ex5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Shop> shops = new ArrayList<>();

        Shop shop1 = new Shop(new ArrayList<>(
                Arrays.asList(new Product("ASUS", 100, "Laptop"),
                        new Product("Iphone X", 123, "Phone"))));
        Shop shop2 = new Shop(new ArrayList<>(
                Arrays.asList(new Product("Broun", 120, "Trimmer"),
                        new Product("Samsung Galaxy", 1023, "Phone"))));

        shops.add(shop1);
        shops.add(shop2);

//        List<Product> list = shop1.getProducts();
//        list.stream() //Stream<Product>
//            .forEach(product -> System.out.println(product.getType()));


        //Вывести наименования товаров типа Phone
//        shops.stream() //запустили стрим Stream<Shop> по магазинам из коллекции shops
//                .map(shop->shop.getProducts()) //Stream<List<Product>>
//                .flatMap(list->list.stream()) //Stream<Product>
//                .filter(product -> product.getType().equals("Phone"))
//                .forEach(product -> System.out.println(product.getName()));



        //короткая версия
        shops.stream() //запустили стрим Stream<Shop> по магазинам из коллекции shops
                .flatMap(shop->shop.getProducts().stream()) //Stream<List<Product>>
                .filter(product -> product.getType().equals("Phone"))
                .forEach(product -> System.out.println(product.getName()));

        //Найти среднюю сумму всех товаров
        double productCount = shops.stream()
                .flatMap(shop -> shop.getProducts().stream()) //Stream<Product>
                .mapToInt(product->product.getPrice()) //Stream<Product> -> IntStream
                .count();

        double sum = shops.stream()
                .flatMap(shop -> shop.getProducts().stream()) //Stream<Product>
                .mapToInt(product->product.getPrice()) //Stream<Product> -> IntStream
                .sum();
        System.out.println(sum/productCount);

        //сокращенный вариант
//        OptionalDouble avr = shops.stream()
//                .flatMap(shop -> shop.getProducts().stream()) //Stream<Product>
//                .mapToInt(product->product.getPrice()) //Stream<Product> -> IntStream
//                .average();

//        System.out.println(avr.getAsDouble());


    }
}
