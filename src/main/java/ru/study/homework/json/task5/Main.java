package ru.study.homework.json.task5;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//    5. Сгенерировать через stream массив из 10 случайных чисел в диапазоне от 2 до 12. Вывести его на консоль в одну строку.
//    После вывести на консоль количество элементов меньше 5 (понадобится count).

        Random rnd = new Random();
        IntStream is = rnd.ints(10, 2, 12);

        int[] array = is.toArray();
        Arrays.stream(array).forEach(x -> System.out.print(x + "  "));

        System.out.println();

        Arrays.stream(array)
                .filter(x -> x < 5)
                .forEach(x -> System.out.print(x + "  "));
        System.out.println("\n" + "\n" + Arrays.stream(array).filter(x -> x < 5).count());

        int res = (int) Arrays.stream(array) // зачем тут приведение типов?
                .filter(x -> x < 5)
                .count();
        System.out.println("\n" + res);


    }
}
