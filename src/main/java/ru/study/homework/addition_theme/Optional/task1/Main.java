package ru.study.homework.addition_theme.Optional.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//    В этих задачах везде вместо лога используйте стандартный System.out.println, так как логи мы еще не проходили.
//
//
//    1. В задании описана только обязательная часть. Можно дописывать свой код. Но не забываем про правила:
//    все поля private, исключаем дублированный код, не складываем все в кучу, а распределяем по отдельным файлам, если это возможно.
//
//    Создать класс Bill (счет) с полями:
//    - сумма платежа;
//    - услуга;
//    - номер платежа.
//
//    Создать класс Company с полями:
//    - название;
//    - баланс (количество денег на счету компании).
//
//    В классе Company создать метод - public Optional<Bill> createBill () - генерирует счет на оплату для клиента, может быть null.
//    Создать класс Client с методом public void pay (Bill bill) - клиент оплачивает сумму, указанную в счете и
//    выводит в консольный лог сообщение с уровнем info об успешном платеже.
//    Перед передачей объекта bill в метод pay необходимо проверить, что объект не равен null.
//    Если bill равен null, то выведите в консольный лог сообщение с уровнем warn.
//    Иначе выведите сообщение с информацией об оплаченном счете с уровнем info.
//    В Main создать объект класса Company, сгенерировать несколько счетов и направить их клиенту(клиентам) на оплату.
//    Обработка null должна быть через средства Optional.

        Scanner scn = new Scanner(System.in);

        System.out.println("Введите название комании:");
        String inputName = scn.nextLine();
        System.out.println("Введите баланс средств на счету:");
        String temp = scn.nextLine();
        int inputBalance = Integer.parseInt(temp);

        Company company = new Company(inputName, inputBalance);

        List<Bill> listBill = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            company.createBill(i).ifPresent(bill->listBill.add(bill));
        }

        System.out.println();

        for (int i = 0; i < listBill.size(); i++) {
            inputBalance = inputBalance - listBill.get(i).getPaymentAmount();
            if(inputBalance > 0){
                Client.pay(listBill.get(i));
            }
            else {
                System.out.println("Счета не могу быть оплачены - баланс счета отрицательный!");
                break;
            }

        }

    }
}
