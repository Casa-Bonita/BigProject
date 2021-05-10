package ru.study.homework.addition_theme.Optional.task1;

public class Bill {

//    Создать класс Bill (счет) с полями:
//    - сумма платежа;
//    - услуга;
//    - номер платежа.

    private int paymentAmount;
    private String service;
    private String transactionNumber;

    public Bill() {
    }

    public Bill(int paymentAmount, String service, String transactionNumber) {
        this.paymentAmount = paymentAmount;
        this.service = service;
        this.transactionNumber = transactionNumber;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPaymentNumber() {
        return transactionNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.transactionNumber = paymentNumber;
    }

    @Override
    public String toString() {
        return "paymentAmount = " + paymentAmount + ", service = " + service + ", paymentNumber = " + transactionNumber;
    }
}