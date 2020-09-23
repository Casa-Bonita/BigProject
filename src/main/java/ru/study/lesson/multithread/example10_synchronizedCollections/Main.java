package ru.study.lesson.multithread.example10_synchronizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Обычная коллекция может работать с потерей данных, так как ее методы не синхронизированы
        //Можно использовать синхронизированные коллекции
        List<Integer> list = Collections.synchronizedList(new ArrayList<>()); //синхронизированный ArrayList
        list.add(0);
        ArrayList<Thread> listThread = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Thread t = new MyThread(list);
            listThread.add(t);
            t.start();
        }

        for(Thread t : listThread){
            t.join();
        }

        System.out.println(list.get(0));


    }

}

class MyThread extends Thread{
    List<Integer> list;

    public MyThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) { //синхронизированная коллекция синхронизирует только то, что происходит в ее методах, а не действия снаружи, поэтому
                //мы должны их дополнительно синхронизировать
                int val = list.get(0);
                val = val + 1;
                Thread.yield();
                list.set(0, val);
            }
        }
    }
}


