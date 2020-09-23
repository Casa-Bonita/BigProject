package ru.study.homework.callable;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//      На кухне работает 5 поваров, производительность каждого 1 заказ в 10 секунд. Всего в кафе поступило N заказов, где N число от 10 до 50.
//      В конце смены каждый повар получает оплату в виде 100 рублей за каждый выполненный заказ.
//      Создать в main выполнение заказов в одном параллельном потоке с помощью ExecutorService.
//      Посчитать заработанную прибыль каждого повара.

        Random rnd = new Random();
        int order = rnd.nextInt(41) + 10;

        System.out.println("Количество заказов = " + order);
        AtomicInteger atomicInteger = new AtomicInteger(order);

        ExecutorService service = Executors.newFixedThreadPool(5);
        //ExecutorService service = Executors.newCachedThreadPool();

        Povar povar1 = new Povar(atomicInteger, 0);
        Povar povar2 = new Povar(atomicInteger, 1);
        Povar povar3 = new Povar(atomicInteger, 2);
        Povar povar4 = new Povar(atomicInteger, 3);
        Povar povar5 = new Povar(atomicInteger, 4);

        List<Future <Integer>> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            list.add(service.submit(povar1));
            list.add(service.submit(povar2));
            list.add(service.submit(povar3));
            list.add(service.submit(povar4));
            list.add(service.submit(povar5));

        }
        for (int i = 0; i < list.size(); i++) {
            Future<Integer> temp = list.get(i);
            System.out.println("Повар " + i + " заработал " + temp.get());
        }



        service.shutdown(); //завершаем работу сервиса

    }
}