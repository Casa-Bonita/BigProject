package ru.study.lesson.multithread.example8_volitile;

import ru.study.homework.multithreading.task4.MyThread;

public class Main {
    volatile static int i=0;
    public static void main(String[] args) {
        //Два потока работают с одной переменной, один ее увеличивает, второй следит за ее изменением и при измении выводит ее новое значение
        //каждый поток кэширует свою компию значения общего ресурса, volatile дает возможность использовать не копию, а оригинальное значение
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
    }


    static class MyThread1 extends Thread{


        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                i++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("thread 1 finished");
        }
    }

    static class MyThread2 extends Thread{
        @Override
        public void run() {
            int val = i;
            while(val<10){
                if(val!=i){
                    System.out.println("new value i = "+i);
                    val = i;
                }
            }
        }
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



