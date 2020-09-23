package ru.study.homework.multithreading.task2;

import java.util.*;

// import static ru.study.homework.multithreading.task2.StringConvertToInt.convert;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//    TEST 2 - START
//    2. Создать калькулятор и выполнять действия с числами в отдельных потоках. Для создания нового потока использовать лямбда выражение.
//    В главном потоке (методе main) создать меню:
//    1. Сложить два числа
//    2. Найти разницу двух чисел
//    3. Выход

        Scanner scn = new Scanner(System.in);

        String input = "";
        DataSource ds = new DataSource();

        MyThreadSum myThread1 = new MyThreadSum();
        MyThreadSubtraction myThread2 = new MyThreadSubtraction();

        System.out.println("Выберите пункт меню:");
        while (!input.equals("3")){

            System.out.println("1. Сложить два числа.");
            System.out.println("2. Найти разницу двух чисел.");
            System.out.println("3. Выход.");
            input = scn.nextLine();

            if(input.equals("1")){

                Thread th1 = new Thread(myThread1);
                th1.start();
                th1.join();


            }else if(input.equals("2")) {


                Thread th2 = new Thread(myThread2);
                th2.start();
                th2.join();


            }else if(input.equals("3")){


                System.out.println("3. Программа завершила свою работу.");

            }else {
                System.out.println("Некорректный ввод.");
            }
        }


    }
}
