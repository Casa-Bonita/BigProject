package ru.study.lesson.multithread.example12_singlePool.example1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Ускоренный способ создания потока - через класс Executors
        int[] arr = {2,4,1,6,9};
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //создаем сервис
        MyCallable myCallable = new MyCallable(arr);
        Future<Integer> future = executorService.submit(myCallable); //запускаем поток с помощью метода submit, который возвращает результат в виде объекта класса Future
        System.out.println(future.get());
        executorService.shutdown(); //завершаем работу сервиса
        System.out.println("main thread end");


    }
}

class MyCallable implements Callable<Integer> {

    int[] arr;

    public MyCallable(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int val : arr){
            Thread.sleep(1000);
            System.out.println("Шаг цикла");
            sum+=val;
        }
        return sum;
    }
}
