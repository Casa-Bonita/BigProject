package ru.study.homework.addition_theme.Comparable.task2;

import ru.study.homework.addition_theme.Comparable.task1.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//    2. Создать класс RealEstate (недвижимость) с private полями:
//    - цена;
//    - площадь;
//    - количество комнат.
//    Реализовать интерфейс Comparable и сортировку, где сначала выполняется сортировка по возрастанию цены, если цена совпадает,
//    то по убыванию площади (так как по одинаковой цене лучше купить недвижимость побольше).
//    Если совпадает и площадь, то по убыванию количества комнат.
//
//    К примеру, имеется набор объектов недвижимости:
//    - Цена: 100, Площадь: 50, Количество комнат: 3;
//    - Цена: 100, Площадь: 60, Количество комнат: 2;
//    - Цена: 100, Площадь: 50, Количество комнат: 4.
//
//    Они должны быть отсортированы следующим образом:
//    - Цена: 100, Площадь: 60, Количество комнат: 2;
//    - Цена: 100, Площадь: 50, Количество комнат: 4;
//    - Цена: 100, Площадь: 50, Количество комнат: 3.

        Scanner scn = new Scanner(System.in);

        Create crt = new Create();

        List<RealEstate> list = crt.create();

        String input = "";

        while(!input.equals("3")){
            System.out.println("1. Comparable.");
            System.out.println("2. Comparator.");
            System.out.println("3. Exit.");

            input = scn.nextLine();

            if (input.equals("1")){
                System.out.println("1. Comparable." + "\n");

                list = crt.create();
                crt.print(list);

                System.out.println("\n" + "После сортировки:");

                Collections.sort(list);
                crt.print(list);

            }
            else if(input.equals("2")){
                System.out.println("2. Comparator." + "\n");

                list = crt.create();
                crt.print(list);

                System.out.println("\n" + "После сортировки:");

                RealEstateComparator rec = new RealEstateComparator();
                list.sort(rec);
                crt.print(list);

            }

            else if(input.equals("3")){
                System.out.println("3. Выход.");

            }
            else{
                System.out.println("Некорректный ввод.");

            }

        }
//Номер поезда, дата отправлени - дата прибытия, стоимость, кнопка купить



    }
}
