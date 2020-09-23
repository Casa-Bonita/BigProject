package ru.study.lesson.multithread.example6_synchronized;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Wrapper wrapper = new Wrapper();
        Runnable r1 = ()->{
            for (int i = 0; i < 20; i++) {
                wrapper.increment();
            }
        };

        Runnable r2 = ()->{
            for (int i = 0; i < 20; i++) {
                wrapper.increment();
            }
        };


        Thread th1 = new Thread(r1);
        th1.start();
        Thread th2 = new Thread(r2);
        th2.start();

        th1.join();
        th2.join();
        System.out.println("Итоговое i = "+wrapper.getI());

    }
}

class Wrapper{
    private int i;
    //теперь метод синхронизирован, и поток, начавший выполнить метод, не прервется до его завершения
    public synchronized void increment(){
        int cur = i;
        cur++;
        Thread.yield();
        i = cur;
    }

    public int getI(){
        return i;
    }
}
