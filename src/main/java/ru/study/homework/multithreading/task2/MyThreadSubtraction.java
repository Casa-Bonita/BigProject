package ru.study.homework.multithreading.task2;

import java.util.*;

public class MyThreadSubtraction implements Runnable{

    @Override
    public void run(){
        DataSource ds = new DataSource();
//        int a = ds.generate();
//        int b = ds.generate();
        int a = ds.inputconvert(1);
        int b = ds.inputconvert(2);
        System.out.println(Thread.currentThread().getName());
        Operations subtraction = ()->{
            int res = a - b;
            System.out.println("A = " + a + "\n" + "B = " + b + "\n" + "Результат = " + res);
        };
        subtraction.calc();
    }

    public void join(){

    }
}
