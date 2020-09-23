package ru.study.lesson.multithread.example12_singlePool.example2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5,13,4,6,0};
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new MyRunnable(arr));
        System.out.println("main thread end");
        executorService.shutdown();

    }
}

class MyRunnable implements Runnable {

    int[] arr;

    public MyRunnable(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int val : arr){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Шаг цикла");
            sum+=val;
        }
        System.out.println("sum = "+sum);
    }
}

