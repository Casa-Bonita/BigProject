package ru.study.lesson.generics.practice1;

public class MainPractice1 {
    public static void main(String[] args) {
        //Создать параметизирвоанный класс с одной переменной и методом проверки наличия значения в этом классе

        SuperContainer <String> sc = new SuperContainer<>("hello world");
        System.out.println(sc.contains("hello java"));
    }
}
