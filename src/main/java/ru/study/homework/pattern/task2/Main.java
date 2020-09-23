package ru.study.homework.pattern.task2;

public class Main {
    public static void main(String[] args) {

//      2. У компании CompanyName, которая производит бытовую технику, есть множество филиалов и единый call-центр,
//      в который могут обращаться клиенты по различным вопросам.
//      Компания сама производит свою технику, поэтому филиалы компании отправляют заказ на завод для поставки новых товаров.
//      Классы, описывающие call-центр и завод, должны быть реализованы с помощью паттерна singleton.
//      Реализовать программу, которая будет уметь:
//      1. Выводить список в конкретном филиале (минимум 2 филиала);
//      2. Заказывать поставку новых товаров в конкретный филиал с завода;
//      3. Покупать товары в конкретном филиале;
//      4. Выводить список покупателей;
//      5. Позволять покупателям отправлять жалобы в call-центр и получать от него ответ.

//        Plant plant = Plant.getInstance();
        BranchLondon branchLondon = new BranchLondon();
        BranchParis branchParis = new BranchParis();

        //CallCenter callCenter = CallCenter.getInstance();
//        ComplaintCall complaintCall = new ComplaintCall();
//        ThanksCall thanksCall = new ThanksCall();



    }
}
