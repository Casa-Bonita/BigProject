package ru.study.homework.synchro.task3;

import java.util.Random;

public class Main {

    static int balance;

    public static void main(String[] args) {

// 3. Есть денежный счет, на который могут поступать денежные средства одновременно из различных источников, а также списываться.
// Нужно сделать так, чтобы все операции были корректно выполнены, чтобы они не потерялись или не перезаписали друг друга.

        int incomingBalance = 100;
        balance = incomingBalance;

        Operation transaction = new Operation();

        Runnable runnable = () ->{
            synchronized (transaction){
                System.out.println(Thread.currentThread().getName());
                int amount = transaction.generate();
                balance = transaction.operation(amount, balance);
            }
        };

        for (int i = 1; i < 6; i++){
            Thread thread = new Thread(runnable);
            thread.setName("Поток " + i);
            thread.start();
        }
    }
}