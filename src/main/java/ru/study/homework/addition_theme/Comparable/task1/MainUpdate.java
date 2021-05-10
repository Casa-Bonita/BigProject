package ru.study.homework.addition_theme.Comparable.task1;

import java.util.*;

public class MainUpdate {
    public static void main(String[] args) {

//    1. Создать класс Planet с полями:
//    - название;
//    - диаметр (дробное число).
//
//    Реализовать в классе интерфейс Comparable, сортирующий планеты по диаметру.
//
//    В Main создать список планет. Ниже приведен список планет в порядке увеличения диаметра, их нужно расположить в ArrayList-е
//    в хаотичном порядке, а затем отсортировать и вывести на консоль.
//    - Меркурий, диаметр 10,2;
//    - Венера, диаметр 11,0;
//    - Земля, диаметр 12,5;
//    - Марс, диаметр 14,1;
//    - Юпитер, диаметр 20,4;
//    - Сатурн, диаметр 25,2.

        Scanner scn = new Scanner(System.in);

        Create crt = new Create();
        DiameterComparator diameterComparator0 = new DiameterComparator(0);
        DiameterComparator diameterComparator1 = new DiameterComparator(1);

        NameComparator nameComparator0 = new NameComparator(0);
        NameComparator nameComparator1 = new NameComparator(1);
        List<Planet> planetList = null;
        String input = "";

        while(!input.equals("9")){
            System.out.println("1. Comparable сортировка по возрастанию диаметра.");
            System.out.println("2. Comparable сортировка по убыванию диаметра.");
            System.out.println("3. Comparable сортировка по наименованию от А до Я.");
            System.out.println("4. Comparable сортировка по наименованию от Я до А.");
            System.out.println("5. Comparator сортировка по возрастанию диаметра.");
            System.out.println("6. Comparator сортировка по убыванию диаметра.");
            System.out.println("7. Comparator сортировка по наименованию от А до Я.");
            System.out.println("8. Comparator сортировка по наименованию от Я до А.");
            System.out.println("9. Exit.");

            input = scn.nextLine();

            if (input.equals("1")){
                System.out.println("1. Comparable сортировка по возрастанию диаметра.");

                planetList = crt.create();
                Collections.sort(planetList, diameterComparator0);


            }
            else if(input.equals("2")){
                System.out.println("2. Comparable сортировка по убыванию диаметра.");

                planetList = crt.create();
                Collections.sort(planetList, diameterComparator1);

            }
            else if(input.equals("3")){
                System.out.println("3. Comparable сортировка по наименованию от А до Я.");

                planetList = crt.create();
                Collections.sort(planetList, nameComparator1);

            }
            else if(input.equals("4")){
                System.out.println("4. Comparable сортировка по наименованию от Я до А.");

                planetList = crt.create();
                Collections.sort(planetList, nameComparator0);

            }

            else if(input.equals("9")){
                System.out.println("9. Выход.");

            }
            else{
                System.out.println("Некорректный ввод.");

            }

            if(planetList!=null) {
                for (Planet p : planetList) {
                    System.out.printf("%-10s %-10s %n", p.getName(), p.getDiameter());
                }
            }

        }



    }
}
