package ru.study.homework.multithreading.task3;

public class MyThread1 extends Thread {

    public void run(){
        for (int i = 0; i < 11; i++) {
            System.out.println(getName() + "   " + i + "   " + "наследование");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
