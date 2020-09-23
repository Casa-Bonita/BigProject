package ru.study.homework.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Povar implements Callable<Integer> {
    private AtomicInteger atomicInteger;
    private  int povarId;

    public Povar(AtomicInteger atomicInteger, int povarId) {
        this.atomicInteger = atomicInteger;
        this.povarId = povarId;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;

        while (atomicInteger.get() > 0) {
            Thread.sleep(1000);

            synchronized (atomicInteger){

                if(atomicInteger.get()>0) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Повар "+povarId+" выполняет заказ");
                    sum = sum + 100;
                    atomicInteger.decrementAndGet();
                }
            }

        }
        return sum;
    }
}

