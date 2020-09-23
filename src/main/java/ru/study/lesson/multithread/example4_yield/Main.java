package ru.study.lesson.multithread.example4_yield;

public class Main {
    public static void main(String[] args) {
        //yield - прерывает работу потока
        //его можно использовать, когда нужно отдать работу другому потоку

        //Запустть два потока выводящие числа от 1 до 5 и сделать так, чтобы второй поток отработал раньше первого

        Runnable r1 = ()->{
            for (int i = 0; i < 5; i++) {
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        };

        Runnable r2 = ()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        };

        Thread th1 = new Thread(r1);
        th1.start();
        Thread th2 = new Thread(r2);
        th2.start();

    }
}
