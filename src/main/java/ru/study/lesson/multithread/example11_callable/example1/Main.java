package ru.study.lesson.multithread.example11_callable.example1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //интерфейс Callable позволяет возвращать результат работы потока
        //Вернуть сумму элементов массива, посчитанную в отдельном потоке
        int[] arr = {2,4,1,5,6};
        MyCallable myCallable = new MyCallable(arr);
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable); //позволит получить результат работы потока
        new Thread(futureTask).start(); //Запускаем поток
        System.out.println(futureTask.get()); //ждем завершения потока и выводим результат операции
        System.out.println("main thread end");

    }
}
//тип интерфейса - это тип, в котором будет возвращаться значение
//в интерфейсе Callable вместо run используется метод call
class MyCallable implements Callable<Integer>{

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
