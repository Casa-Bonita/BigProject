package ru.study.homework.synchro.task3;

import java.util.*;

public class Operation {
    private int amount;
    private int balance;

    Random rnd = new Random();

    public int generate(){
        amount = rnd.nextInt(100) + 1;
        int sign = rnd.nextInt(2);
        if(sign == 0){
            amount = -amount;
        }else{
            amount = amount;
        }
        return amount;
    }

    public int operation(int amount, int balance){
        this.amount = amount;
        this.balance = balance;
        if(amount > 0){
            System.out.println("Поступила сумма = " + amount);
            balance = balance + amount;
            System.out.println("Операция проведена. Остаток средств на счете = " + balance + "\n");
            return balance;
        }else {
            System.out.println("Поступил документ на списание суммы = " + amount);
            if ((balance + amount) < 0) {
                System.out.println("Операция не может быть проведена. Недостаточно средств на счете.");
                System.out.println("Остаток средств на счете = " + balance + "\n");
                return balance;
            } else {
                balance = balance + amount;
                System.out.println("Операция проведена. Остаток средств на счете = " + balance + "\n");
                return balance;
            }
        }
    }
}
