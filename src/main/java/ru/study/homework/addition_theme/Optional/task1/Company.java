package ru.study.homework.addition_theme.Optional.task1;

import java.util.Optional;
import java.util.Random;

public class Company {

//    Создать класс Company с полями:
//    - название;
//    - баланс (количество денег на счету компании).



    private String companyName;
    private int balanceAmount;

    public Company(String companyName, int balanceAmount) {
        this.companyName = companyName;
        this.balanceAmount = balanceAmount;
    }

    public Optional<Bill> createBill (int i){

        Random rnd = new Random();

        int temp = rnd.nextInt(3);

        if(temp == 0){

            return Optional.empty();

        }else{
            int paymentAmount = temp * 100;
            String service = "service_" + String.valueOf(temp);
            String paymentNumber = "paymentNumber_" + String.valueOf(i);

            Bill bill = new Bill(paymentAmount, service, paymentNumber);

            return Optional.ofNullable(bill);
        }


    }
}
