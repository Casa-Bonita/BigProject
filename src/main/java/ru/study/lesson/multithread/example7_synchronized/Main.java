package ru.study.lesson.multithread.example7_synchronized;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Передавать значения в потоки можно и через конструктор
        //есть общий ресурс - переменная i, два потока увеличивают ее 20 раз каждый синхроинизированно
        WrapperI i = new WrapperI();
        MyThread t1 = new MyThread(i);
        MyThread t2 = new MyThread(i);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}


class WrapperI{
    private int i=0;
    public synchronized void increment(){
        i++;
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }
}


class MyThread extends Thread{
    private WrapperI i;

    public MyThread(WrapperI i) {
        this.i = i;
    }

    @Override
    public void run() {
        for (int j = 0; j < 20; j++) {
            Thread.yield();
            i.increment();
        }
    }
}
