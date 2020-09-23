//package ru.study.homework.pattern.task1;
//
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Main {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
////      1. Сравнить скорость выполнения задачи с применением newCachedThreadPool и newFixedThreadPool.
////      На стройке рабочие возводят новое здание. Условно здание состоит из 100 деталей. Каждый рабочий добавляет одну деталь за 1 секунду.
////      Для сравнения скорость работы решите задачу двумя способами:
////      1. через newFixedThreadPool, когда количество рабочих ограничено 10 людьми;
////      2. через newFixedThreadPool, когда количество рабочих не ограничено вообще. Можно добавлять новых рабочих до бесконечности до тех пор, пока здание не построится.
////
////      Для наглядности выводите на консоль название и номера потоков или номера рабочих, чтобы пронаблюдать, сколько человек будет задействовано в первом и во втором случае.
//
//        int detail = 100;
//        System.out.println("Количество деталей = " + detail);
//
//        String input = "";
//        while (!input.equals("4")){
//            System.out.println("\n" + "1. Демонстрация newFixedThreadPool");
//            System.out.println("2. Демонстрация newCachedThreadPool");
//            System.out.println("3. Демонстрация newSingleThreadExecutor");
//            System.out.println("4. Выход.");
//            Scanner scn = new Scanner (System.in);
//            input = scn.nextLine();
//            if(input.equals("1")){
//                System.out.println("1. Демонстрация newFixedThreadPool");
//
//                ExecutorService serviceFixed = Executors.newFixedThreadPool(10);
//
//                AtomicInteger atomicInteger = new AtomicInteger(detail);
//                List<Worker> workers = new ArrayList();
//                for (int i = 0; i < 10; i++) {
//                    workers.add(new Worker(atomicInteger, i));
//                }
////                Worker worker0 = new Worker(atomicInteger, 0);
////                Worker worker1 = new Worker(atomicInteger, 1);
////                Worker worker2 = new Worker(atomicInteger, 2);
////                Worker worker3 = new Worker(atomicInteger, 3);
////                Worker worker4 = new Worker(atomicInteger, 4);
////                Worker worker5 = new Worker(atomicInteger, 5);
////                Worker worker6 = new Worker(atomicInteger, 6);
////                Worker worker7 = new Worker(atomicInteger, 7);
////                Worker worker8 = new Worker(atomicInteger, 8);
////                Worker worker9 = new Worker(atomicInteger, 9);
//
//                List<Future <Integer>> listFixed = new ArrayList<>();
//                for (int i = 0; i < workers.size(); i++) {
//                    listFixed.add(serviceFixed.submit(workers.get(i)));
//                }
////                listFixed.add(serviceFixed.submit(worker0));
////                listFixed.add(serviceFixed.submit(worker1));
////                listFixed.add(serviceFixed.submit(worker2));
////                listFixed.add(serviceFixed.submit(worker3));
////                listFixed.add(serviceFixed.submit(worker4));
////                listFixed.add(serviceFixed.submit(worker5));
////                listFixed.add(serviceFixed.submit(worker6));
////                listFixed.add(serviceFixed.submit(worker7));
////                listFixed.add(serviceFixed.submit(worker8));
////                listFixed.add(serviceFixed.submit(worker9));
//
//                for (int i = 0; i < listFixed.size(); i++) {
//                    Future<Integer> temp = listFixed.get(i);
//                    System.out.println("Рабочий " + i + " установил " + temp.get() + " деталей.");
//                }
//
//                serviceFixed.shutdown();
//
//            }
//            else if(input.equals("2")){
//                System.out.println("2. Демонстрация newCachedThreadPool");
//
//                ExecutorService serviceCached = Executors.newCachedThreadPool();
//
//                AtomicInteger atomicInteger = new AtomicInteger(detail);
//
//                List<Worker> workers = new ArrayList();
//                for (int i = 0; i < 100; i++) {
//                    workers.add(new Worker(atomicInteger, i));
//                }
//
//                List<Future <Integer>> listCached = new ArrayList<>();
//                for (int i = 0; i < workers.size(); i++) {
//                    listCached.add(serviceCached.submit(workers.get(i)));
//                }
//
//                for (int i = 0; i < listCached.size(); i++) {
//                    Future<Integer> temp = listCached.get(i);
//                    System.out.println("Рабочий " + i + " установил " + temp.get() + " деталей.");
//                }
//
//                serviceCached.shutdown();
//
//            }
//            else if(input.equals("3")){
//                System.out.println("1. Демонстрация newSingleThreadExecutor");
//
////                List<String> listSingle = new ArrayList<>();
////                listSingle.add("worker0");
////                listSingle.add("worker1");
////                listSingle.add("worker2");
////                listSingle.add("worker3");
////                listSingle.add("worker4");
////                listSingle.add("worker5");
////                listSingle.add("worker6");
////                listSingle.add("worker7");
////                listSingle.add("worker8");
////                listSingle.add("worker9");
////
////                List<Integer> listResult = new ArrayList<>();
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////                listResult.add(0);
////
////                AtomicInteger atomicInteger = new AtomicInteger(detail);
////
////                ExecutorService serviceSingle = Executors.newSingleThreadExecutor();
////
////                WorkerSingle workerSingle = new WorkerSingle(atomicInteger, listSingle, listResult);
////
////                Future<List <Integer>> future = serviceSingle.submit(workerSingle);
////
////                System.out.println(future.get());
////
////                serviceSingle.shutdown();
//
//        }
//
//
//    }
//}
