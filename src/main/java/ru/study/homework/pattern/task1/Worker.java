package ru.study.homework.pattern.task1;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Callable<Integer> {
    private AtomicInteger atomicInteger;
    private int workerID;

    public Worker(AtomicInteger atomicInteger, int workerID){
        this.atomicInteger = atomicInteger;
        this.workerID = workerID;
    }


    @Override
    public Integer call() throws Exception{
        int sum = 0;

        while (atomicInteger.get() > 0){
            Thread.sleep(10);
            synchronized (atomicInteger){
                if(atomicInteger.get() > 0){
                    Thread.currentThread().setName("поток " + workerID);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Рабочий " + workerID + " выполняет заказ ");
                    sum = sum + 1;
                    atomicInteger.decrementAndGet();

                }
            }

        }

        return sum;
    }


}
