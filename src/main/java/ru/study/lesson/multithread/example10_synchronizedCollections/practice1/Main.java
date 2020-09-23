package ru.study.lesson.multithread.example10_synchronizedCollections.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        //Есть склад товаров, его разгружают одновременно 2 грузовика вместимостью 5 каждый и параллеьно на скалд доставляют новый товар другие 2 грузовика вместимостью 3 каждый
        //Нужно разгружить склад, начальное количество 20 товаров
        //Все грузовики будут рабоать до тех опр, пока склад не опустеет

        Counter counter = new Counter();
        Sklad sklad = new Sklad(counter);

        Lorry lorryDeliver1 = new Lorry(sklad, 3, true);
        Lorry lorryDeliver2 = new Lorry(sklad, 3, true);
        Lorry lorryUnloading1 = new Lorry(sklad, 5, false);
        Lorry lorryUnloading2 = new Lorry(sklad, 5, false);

        List<Lorry> lorryList = Arrays.asList(lorryDeliver1, lorryDeliver2, lorryUnloading1, lorryUnloading2);

        for(Lorry lorry : lorryList){
            lorry.start();
        }
    }
}

class Counter{
    AtomicInteger ai = new AtomicInteger(20);
}

class Sklad{
    Counter counter;
    List<String> list = Collections.synchronizedList(new ArrayList<>());

    public Sklad(Counter counter){
        for (int i = 0; i < 20; i++) {
            list.add("tovar" + i);
        }
        this.counter = counter;
    }

    public void add(){
        list.add("tovar" + counter.ai.incrementAndGet());
        System.out.println(Thread.currentThread().getName()+" Доставил товар " + counter.ai.get());
    }

    public void remove(){
        String str = list.remove(0);
        System.out.println(Thread.currentThread().getName()+" Вывез "+str);
    }

    public int size(){
        return list.size();
    }
}

class Lorry extends Thread{
    private Sklad sklad;
    private int volume;
    private boolean isDeliver;

    public Lorry(Sklad sklad, int volume, boolean isDeliver) {
        this.sklad = sklad;
        this.volume = volume;
        this.isDeliver = isDeliver;
    }

    public synchronized void deliver() {
        for (int i = 0; i < volume && sklad.size()>0; i++) {
            sklad.add();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void unloading(){
        for (int i = 0; i < volume && i < sklad.size(); i++) {
            sklad.remove();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(sklad.size() > 0){

            if(isDeliver){

                deliver();
            }else{
                unloading();
            }
        }
    }
}
