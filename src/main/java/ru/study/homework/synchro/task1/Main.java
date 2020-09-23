package ru.study.homework.synchro.task1;

public class Main {
    public static void main(String[] args){

// 1. Написать программу, в которой будем собирать автомобиль: двигатель готов, кузов готов, колеса готовы, автомобиль собран.
// Строка автомобиль собран должна выводиться в конце сборки остальных деталей.
        
        Runnable runnable1 = ()->{
            System.out.println("\n" + Thread.currentThread().getName());
            System.out.println("Сборка колёс начата.");
            for (int i = 1; i < 5; i++) {
                System.out.println("Собрано колесо " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Сборка колёс завершена. Колёса собраны!" + "\n");
        };

        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Сборка кузова начата.");
            for (int i = 1; i < 7; i++) {
                System.out.println("Установлена деталь " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Сборка кузова завершена. Кузов собран!" + "\n");
        };

        Runnable runnable3 = () ->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("Сборка двигателя начата.");
            for (int i = 1; i < 6; i++) {
                System.out.println("Установлена деталь " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Сборка двигателя завершена. Двигатель собран!" + "\n");
        };

        Thread thread1 = new Thread(runnable1, "поток 1");
        Thread thread2 = new Thread(runnable2, "поток 2");
        Thread thread3 = new Thread(runnable3, "поток 3");

        thread1.start();

        try {
            thread1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        thread2.start();

        try{

            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        thread3.start();

        try{

            thread3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Автомобиль собран!");

    }
}
