package ru.study.homework.multithreading.task3;

public class MyThread2 extends Thread {

    public void run(){
        for (int i = 20; i < 31; i++) {
            System.out.println("                                     " + getName() + "   " + i + "   " + "наследование");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
