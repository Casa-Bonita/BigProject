package ru.study.homework.addition_theme.Optional.task1;

public class Client {

    private Bill bill;

    public static void pay (Bill bill){

        System.out.println(bill.getPaymentNumber() + " оплачено");
        System.out.printf("%-20s %-20s %n", bill.getPaymentAmount(), bill.getService());

    }

    public static void unPay (int i){

        String paymentNumber = "paymentNumber_" + i;
        System.out.println(paymentNumber + " - НЕ оплачено");

    }
}
