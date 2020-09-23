package ru.study.lesson.multithread.example9_atomic;



import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //атомарные операции - синхронизированные операции
        //несколько потоков увеличивают 20 раз переменную i. Это можно сделать (увеличение) через атомарную операцию
        AtomicInteger ai = new AtomicInteger(0);
        ArrayList<Thread> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            Thread t = new MyThread(ai);
            list.add(t);
            t.start();
        }

        for(Thread t : list){
            t.join();
        }
        System.out.println(ai.get());

    }
}


class MyThread extends Thread{
    private AtomicInteger ai;

    public MyThread(AtomicInteger ai) {
        this.ai = ai;
    }

    @Override
    public void run() {
        for (int j = 0; j < 20; j++) {
            Thread.yield();
            ai.incrementAndGet();
        }
    }
}