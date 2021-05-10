package ru.study.homework.addition_theme.Collections.task3;

import javax.xml.crypto.Data;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//    3. Создать программу, имитирующую работу ресторана в части заказа блюд из меню.
//
//    Создать класс Dish (блюдо) с private полями:
//    - название блюда;
//    - цена блюда.
//    Переопределить метод toString.
//    Переопределить equals и hashCode, чтобы HashSet мог понимать, как объекты класса Dish являются дубликатами.
//    Остальную структуру класса Dish дополнить самостоятельно по необходимости.
//
//    Создать меню на основе класса Menu.
//    В классе Menu создать поле:
//    - public static HashSet<Dish> menu = new HashSet(); //Статический, множество уникальных блюд, представляющее меню.
//    В него нужно добавить блюда перед началом работы ресторана. Блюда вводятся пользователем с консоли. Чтобы исключить дубликаты, используется HashSet.
//    Переопределить метод toString.
//    Остальную структуру класса Menu дополнить самостоятельно по необходимости.
//
//    Создать класс Client с private полями:
//    - tableNumber; //номер столика
//    - ArrayList<Dish> orders = new ArrayList(); //список заказов
//    Переопределить метод toString.
//    Остальную структуру класса Client дополнить самостоятельно по необходимости.
//
//    Клиенты ресторана должны обслуживать в порядке очереди.
//
//    В Main создать поток клиентов и их заказов следующим способом:
//    - сгенерировать случайное число n - количество клиентов;
//    - для каждого клиента сгенерировать случайное число m - количество заказов для каждого клиента;
//    - блюда из меню выбирать случайным образом.
//
//    Итого, каждый клиент должен обслуживаться в порядке очереди.
//    На консоли нужно вывести клиентов (номер столика и их заказы) и счет в порядке очереди.

        Menu menu = new Menu();
        Dish dish = new Dish();
        Client client;

        List<Client> clientList = new ArrayList<>();
        List<Integer> tableList = new ArrayList<>();

        // создание меню ресторана в формате: "название блюда" + "цена"
        for (int i = 0; i < 30; i++) {
            menu.addDish(dish.create(i));
        }

        System.out.println("Создано меню ресторана:");
        menu.printMenu();

        System.out.println("\n" + "Количество блюд в меню: " + menu.getSize() + "\n");

        // создание потока клиентов
        Random rnd = new Random();
        int n = rnd.nextInt(20) + 1; // количество клиентов

        System.out.println("Количество клиентов в ресторане: " + n + "\n");

        // заполняем список со столиками номерами столов
        for (int i = 0; i < n; i++) {
            tableList.add(i);
        }

        // перемешиваем столики внутри списка, т.к. клиента могут посадить за любой столик
        Collections.shuffle(tableList);

        for (int i = 0; i < n; i++) {

            // создание списка блюд в заказе клиента
            ArrayList<Dish> orders = new ArrayList();
            int m = rnd.nextInt(4) + 1; // количество заказав у одного клиента
            for (int j = 0; j < m; j++) {
                dish = menu.getRandomElement();
                orders.add(dish);
            }

            // сортировка блюд клиента методом пузырька
            orders = dish.dishSort(orders);

            System.out.println("Клиент " + i + " находится за столиком = " + tableList.get(i));
            System.out.println("Выбраны блюда для клиента " + i + " :");
            for (int j = 0; j < m; j++) {
                dish = orders.get(j);
                System.out.printf("%-15s %-15s %n", dish.getName(), dish.getPrice());
            }

            client = new Client(tableList.get(i), orders);
            clientList.add(client);
            System.out.println();
        }


        System.out.println("Счет для каждого клиента:");
        for (int i = 0; i < clientList.size(); i++) {
            client = clientList.get(i);
            List<Dish> clientDish = client.getOrders();
            int amount = 0;
            for (int j = 0; j < clientDish.size(); j++) {
                dish = clientDish.get(j);
                amount = amount + dish.getPrice();
            }
            System.out.println("Счет для клиента = " + i + " равняется " + amount + " столик номер = " + client.getTableNumber());
        }

    }
}
