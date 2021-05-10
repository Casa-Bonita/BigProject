package ru.study.homework.addition_theme.Collections.task1;

import java.util.Optional;
import java.util.Scanner;

public class MainUpdate {
    public static void main(String[] args) {

//    1. Реализовать свой аналог класса ArrayList, который будет хранить только значения в типе String, с методами:
//    add, get, size, contains, indexOf, remove по индексу, remove по значению.


        Scanner scn = new Scanner(System.in);

        Create crt = new Create();

        MyArrayList myArrayList = new MyArrayList();

        String input = "";

        while(!input.equals("12")){
            System.out.println("1. Create list.");
            System.out.println("2. Read list.");
            System.out.println("3. Метод add.");
            System.out.println("4. Read list after increase.");
            System.out.println("5. Метод get by value.");
            System.out.println("6. Метод get by id.");
            System.out.println("7. Метод size.");
            System.out.println("8. Метод contains.");
            System.out.println("9. Метод indexOf.");
            System.out.println("10. Метод remove by Index.");
            System.out.println("11. Метод remove by value.");
            System.out.println("12. Exit.");

            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Create list.");

                int j = 0;
                for (int i = 0; i < 10; i++) {
                    Optional<String> temp = crt.create();
                    temp.ifPresent(val->myArrayList.add(val));
                }

            }
            else if(input.equals("2")){
                System.out.println("2. Read list.");

                System.out.println("Размер списка = " + myArrayList.size());
                for (int i = 0; i < myArrayList.size(); i++) {
                    System.out.printf("%-10s %-10s %n", i, myArrayList.get(i));
                }

            }
            else if(input.equals("3")){
                System.out.println("3. Метод add.");
                System.out.println("Введите элемент списка:");
                String element = scn.nextLine();
                myArrayList.add(element);

            }
            else if(input.equals("5")){
                //TODO
                System.out.println("5. Метод get by value.");


                String element = "";
                while(element.equals("")) {
                    System.out.println("Введите элемент списка:");
                    element = scn.nextLine();
                }

                int index = myArrayList.indexOf(element);
                if(index==-1){
                    System.out.println("Элемент " + element + " отсутствует в коллекции");
                }else{
                    System.out.println("Элемент " + element + " присутствует в коллекции под номером = " + index);
                }

            }
            else if(input.equals("6")){
                System.out.println("6. Метод get by id.");
                System.out.println("Введите порядковый номер элемента списка:");
                String temp = scn.nextLine();
                int index = Integer.parseInt(temp);
                if(index >=0 && index< myArrayList.size()){
                    System.out.println(myArrayList.get(index));
                }else{
                    System.out.println("ДАнный индекс не существует");
                }
            }
            else if(input.equals("7")){
                System.out.println("7. Метод size.");
                System.out.println("Размер коллекции = " + myArrayList.size());

            }

            else if(input.equals("10")){
                System.out.println("10. Метод remove by Index.");
                System.out.println("Введите порядковый номер элемента списка:");
                String temp = scn.nextLine();
                int index = Integer.parseInt(temp);
                if(myArrayList.remove(index)){
                    System.out.println("Элемент удален");
                }else{
                    System.out.println("Элемент не удален");
                }

            }
            else if(input.equals("11")){
                System.out.println("11. Метод remove by value.");
                System.out.println("Введите значение элемента списка:");
                String element = scn.nextLine();

                if(myArrayList.remove(element)){
                    System.out.println("Элемент удален");
                }else{
                    System.out.println("Элемент не удален");
                }

            }
            else if(input.equals("12")){
                System.out.println("12. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");

            }

        }



    }
}
