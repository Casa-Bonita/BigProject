package ru.study.homework.java8.task1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

//    1. Используя один stream создать массив из 10-и случайных чисел в диапазоне от -10 до 20.
//    После заполнения в отдельных stream найти сумму чисел (метод sum) и максимальное число (метод max) в массиве.

        int [] array = new Random().ints(10,-10,20).toArray();

        System.out.println("Созданный массив:");
        Arrays.stream(array)
                .forEach(x -> System.out.print(x + "  "));


        int sum = Arrays.stream(array)
                .sum();
        System.out.println("\n" + "\n" + "Сумма элементов массива = " + sum);


        OptionalInt maxTemp = Arrays.stream(array)
                .max();

        int max = maxTemp.getAsInt();

        System.out.println("\n" + "Максимальное число в массиве = " + max);

    }
}
