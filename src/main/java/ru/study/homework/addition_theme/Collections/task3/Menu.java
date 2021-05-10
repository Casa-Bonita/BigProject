package ru.study.homework.addition_theme.Collections.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {
//    Создать меню на основе класса Menu.
//    В классе Menu создать поле:
//    - public static HashSet<Dish> menu = new HashSet(); //Статический, множество уникальных блюд, представляющее меню.
//    В него нужно добавить блюда перед началом работы ресторана. Блюда вводятся пользователем с консоли. Чтобы исключить дубликаты, используется HashSet.
//    Переопределить метод toString.
//    Остальную структуру класса Menu дополнить самостоятельно по необходимости.

    public static HashSet<Dish> menu = new HashSet();

    public void addDish(Dish dish){
        menu.add(dish);
    }

    public void printMenu(){
        menu.stream()
                .sorted(Comparator.comparing(menu -> menu.getName()))
                .collect(Collectors.toList())
                .forEach(menu -> System.out.printf("%-15s %-15s %n", menu.getName(), menu.getPrice()));
    }

    public int getSize(){
        return menu.size();
    }

    public Dish getRandomElement(){
        Random rnd = new Random();
        int index = rnd.nextInt(menu.size());
        for(Dish d : menu){
            String name = d.getName();
            String[] arrayName = name.split("-");
            int temp = Integer.parseInt(arrayName[1]);
            if(index == temp){
                return d;
            }
        }
        return null;
    }

}
