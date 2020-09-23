package ru.study.lesson.multithread.example3_join;

import java.util.Random;

public class Main {
    static int sum1 = 0 ;
    static int sum2 = 0 ;
    public static void main(String[] args) throws InterruptedException {
        //Мы хотим сгенерировать и заполнить два массива в одтельных потоках, найти их сумму в других потоках и в главном потоке найти разницу двух сумм
        //если в потоке 1 вызывается join у потока 2, то поток1 будет ждать завершения потока 2
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        Random rnd = new Random();

        Runnable runnable1 = ()->{
            System.out.println("Заполнение массива 1");
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = rnd.nextInt(20);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = ()->{
            System.out.println("Заполнение массива 2");
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = rnd.nextInt(20);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread th1 = new Thread(runnable1);
        th1.start();
        Thread th2 = new Thread(runnable2);
        th2.start();

        th1.join();
        th2.join();

        runnable1 = ()->{
            System.out.println("Поиск суммы 1");
            for (int i = 0; i < arr1.length; i++) {
                sum1+= arr1[i];
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        runnable2 = ()->{
            System.out.println("Поиск суммы 2");
            for (int i = 0; i < arr2.length; i++) {
                sum2+= arr2[i];
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        th1 = new Thread(runnable1);
        th1.start();
        th2 = new Thread(runnable2);
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Разница сумм = "+(sum1-sum2));



    }
}
