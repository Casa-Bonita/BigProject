package ru.study.lesson.multithread.example1;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //многопоточность
        //вывести числа от 0 до 5 параллельно в двух потоках

        //способ 1
//        MyThread myThread1 = new MyThread();
//        MyThread myThread2 = new MyThread();
//        myThread1.start();
//        myThread2.start();

        //способ 2
        MyThread2 myThread21 = new MyThread2();
        MyThread2 myThread22 = new MyThread2();
        new Thread(myThread21).start();
        new Thread(myThread22).start();

    }
}

////способ 1
//class MyThread extends Thread{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(getName()+" "+i);
//            try {
//                sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//}

//способ 2
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
