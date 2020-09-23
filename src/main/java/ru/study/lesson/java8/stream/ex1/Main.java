package ru.study.lesson.java8.stream.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //String[] arr = {"one", "two", "three"};
        //вывод элементов на консоль
//        Stream<String> s = Arrays.stream(arr);
//        //s.forEach((x)-> System.out.println(x)); //через лямбда
//        s.forEach(System.out::println); //через ссылку

        //В укроченной версии:
        //Arrays.stream(arr).forEach(System.out::println);


        //промежуточная операция filter (фильтрует занчение)
        //Вывести только те строки из массива, чья длина меньше 4
//        Arrays.stream(arr)
//                .filter(x->x.length()<4)
//                .forEach(System.out::println);


        //Stream<T> - общий класс для потоков, может работать с объектами любых типов
        //У него есть конкретные аналоги, работающие с конкретными типами: int, double, ... примитивные типы
        //IntStream - поток, который работает только с числами

        //Пример IntStream
//        int[] arr = {1,5,1,23,5};
//        IntStream s = Arrays.stream(arr);
//        //Найдем сумму всех чисел в массиве, которые больше 4
//        int res = s.filter(x->x>4).sum();
//        System.out.println(res);
//
//        //укороченная версия
//        int res2 = Arrays.stream(arr)
//                .filter(x->x>4)
//                .sum();
//        System.out.println(res2);
//

        //Сгенерировать 10 случ чисел в диапазоне от 1 до 15 и обернуть их в коллекццию

//        Random rnd = new Random();
//        IntStream s = rnd.ints(10, 1, 15);
//        //конвертируем IntStream в Stream<Integer>
//        Stream<Integer> s2 = s.boxed();
//        //Сфорируем коллекцию
//        List<Integer> list = s2.collect(Collectors.toList());
//
//        //выведем полученные числа из коллекции
//        list.stream().forEach(x-> System.out.print(x+" "));

        //укороченная версия:
        Random rnd = new Random();
        List<Integer> list = rnd.ints(10, 1, 15)
                .boxed() //конверитрует IntStream в общий класс потока Stream<Integer>
                .collect(Collectors.toList());
        //выведем полученные числа из коллекции
        list.stream().forEach(x-> System.out.print(x+" "));










    }
}
