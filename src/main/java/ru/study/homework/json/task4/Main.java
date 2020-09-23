package ru.study.homework.json.task4;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
//    4. Сгенерировать через stream массив из 10 случайных чисел в диапазоне от 2 до 12. Вывести его на консоль в одну строку.
//    После вывести на консоль из массива только числа, которые больше 5.

//        Random rnd = new Random();
//        IntStream is = rnd.ints(10, 2, 12);
//
//        int[] array = is.toArray();
//
//        Stream<int[]> tempArray = Stream.of(array);
//        IntStream stream = tempArray.flatMapToInt(x -> Arrays.stream(x));
//        stream.forEach(x -> System.out.print(x + "  "));
//
//        System.out.println();
//
//        Arrays.stream(array)
//                .filter(x -> x > 5)
//                .forEach(x -> System.out.print(x + "  "));


        int[] array = new Random().ints(10, 2, 12).toArray();
        Arrays.stream(array).forEach(x-> System.out.print(x+" "));
        System.out.println();
        Arrays.stream(array)
                .filter(x->x>5)
                .forEach(x-> System.out.print(x+" "));
        System.out.println();


    }
}

