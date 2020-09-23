package ru.study.homework.synchro.task2;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    public static void main(String[] args) {

// 2. Написать программу с тремя потоками. В одном потоке происходит заполнение массива, второй поток ждет заполнения и после этого
// считает сумму элементов в массиве. В это время, пока эти два потока работают, в главном потоке выводится меню с пунктами:
// 1. Попить чай
// 2. Попить кофе
// 3. Выход
// Причем, в главном потоке, после подсчета суммы (при условии, что меню уже завершилось) нужно вывести элементы заполненного массива на консоль.
// Если же сумма уже посчиталась, а меню еще работает, то сначала нужно выйти из меню.

        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();
        int [] array = new int [10];

        Runnable runnable1 = () ->{

            System.out.println("\n" + "Заполнение элементов массива");
            for (int i = 0; i < array.length; i++) {
                array[i] = rnd.nextInt(49) + 1;
                System.out.println("Элемент массива" + i + " равен " + array[i]);
            }
        };
        Thread thread1 = new Thread(runnable1, "поток 1");

        Runnable runnable2 = () ->{
            System.out.println("\n" + "Подсчёт суммы элементов массива");
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }
            System.out.println("Сумма элементов массива = " + sum + "\n");
            System.out.println("Элементы массива:");
            for (int i = 0; i < array.length; i++) {
                System.out.println("Элемент массива " + i + " равен " + array[i]);
            }
        };
        Thread thread2 = new Thread(runnable2, "поток 2");

        Runnable runnableMain = () ->{
            String input = "";
            while(!input.equals("3")){
                System.out.println("1. Попить чай.");
                System.out.println("2. Попить кофе.");
                System.out.println("3. Выход.");
                input = scn.nextLine();
                if(input.equals("1")){
                    System.out.println("1. Давайте попьём чай.");
                }else if(input.equals("2")){
                    System.out.println("2. Давайте попьём кофе.");
                }else if (input.equals("3")){
                    System.out.println("3. Консольное меню завершило свою работу.");
                }else{
                    System.out.println("Некорректный ввод.");
                }
            }
        };
        Thread threadMain = new Thread(runnableMain, "Главный поток");

        thread1.start();
        threadMain.start();

        try{
            thread1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        thread2.start();



//        try{
//            threadMain.join();
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//
//
//

//
//        thread2.start();
    }
}
