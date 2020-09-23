package ru.study.homework.multithreading.task3;

public class MyThread3 implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i < 11; i++) {
            System.out.println("                                                                          " + Thread.currentThread().getName() + "   " + i + "   " + "интерфейс");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
