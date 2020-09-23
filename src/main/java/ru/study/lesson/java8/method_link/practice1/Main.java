package ru.study.lesson.java8.method_link.practice1;

public class Main {
    public static void main(String[] args) {
        //Написать функциоанльный интерфейс с методом приветствия и вызвать его метод через ссылку на метод
        Service s = new Service();
        //Greeting gr = (text)->s.greet(text); //через лямбда выражение
        Greeting greeting = s::greet; //через ссылку
        greeting.greet("hello");

    }


}
