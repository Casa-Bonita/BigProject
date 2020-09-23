package ru.study.lesson.multithread.example12_singlePool.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception{
        //Есть магазин, в который приходит n покупаетелей. Нужно получить список проданных товаров и найти выручку
        List<Tovar> listTovar = new ArrayList<>(){
            {
                for (int i = 1; i < 40; i++) {
                    add(new Tovar(10*i, "Tovar"+i));
                }

            }
        };

        ExecutorService buyers = Executors.newSingleThreadExecutor();
        List<Future<Tovar>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Future<Tovar> f = buyers.submit(new Client(listTovar));
            futures.add(f);
        }

        buyers.shutdown();

        int sum = 0;
        for (Future<Tovar> tovarFuture: futures) {
            sum = sum + tovarFuture.get().getPrice();
        }
        System.out.println("Выручка = " + sum);

    }
}


class Tovar{
    private int price;
    private String name;

    public Tovar(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

class Client implements Callable<Tovar>{
    private List<Tovar> tovarList;

    public Client(List<Tovar> tovarList) {
        this.tovarList = tovarList;
    }

    public synchronized Tovar buying(){

        Random rnd = new Random();
        int index = rnd.nextInt(tovarList.size());
        Tovar tovar = tovarList.remove(index);
        System.out.println("Клиент купил "+tovar.getName());

        return tovar;
    }

    @Override
    public Tovar call() throws Exception {

        Tovar tovar = buying();
        return tovar;
    }
}