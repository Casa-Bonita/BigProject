package ru.study.homework.multithreading.task3;

public class Main {
    public static void main(String[] args) {

//    TEST 3 - START
//    3. Создать два потока, вывести в первом потоке числа от 0 до 10, во втором - от 20 до 30 (можно использовать лямбда выражение)

        // Создание потоков через наследование.

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();


        // Создание потоков через интерфейс.

        MyThread3 myThread3 = new MyThread3();
        new Thread(myThread3).start();

        MyThread4 myThread4 = new MyThread4();
        new Thread(myThread4).start();


    }
}
