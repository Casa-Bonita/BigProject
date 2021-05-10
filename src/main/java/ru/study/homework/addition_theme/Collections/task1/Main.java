package ru.study.homework.addition_theme.Collections.task1;

import java.util.Optional;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//    1. Реализовать свой аналог класса ArrayList, который будет хранить только значения в типе String, с методами:
//    add, get, size, contains, indexOf, remove по индексу, remove по значению.


        Scanner scn = new Scanner(System.in);

        Create crt = new Create();

        String [] myList = new String[10];


        String [] newMyList = null;

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
                for (int i = 0; i < myList.length; i++) {
                    Optional<String> temp = crt.create();



                    if(temp.isPresent()){
                        myList[j] = temp.get();
                        j++;
                    }
                }

            }
            else if(input.equals("2")){
                System.out.println("2. Read list.");

                System.out.println("Размер списка = " + myList.length);
                for (int i = 0; i < myList.length; i++) {
                    System.out.printf("%-10s %-10s %n", i, myList[i]);
                }

            }
            else if(input.equals("3")){
                System.out.println("3. Метод add.");

                System.out.println("Введите элемент списка:");
                String element = scn.nextLine();

                // проверка нужно ли увеличивать массив
                Optional<String> lastElement = Optional.ofNullable(myList[myList.length - 1]);
                if (lastElement.isPresent()) {

                    System.out.println("Первоначальный список заполнен, будет создан новый список.");

                    // создание нового массива
                    newMyList = new String[myList.length * 3 / 2];

                    // копирование массива в новый массив
                    System.arraycopy(myList, 0, newMyList, 0, myList.length); //- не работает
//                    for (int i = 0; i < length; i++) {
//                        newMyList[i] = myList[i];
//                    }
                    // добавление введённоо элемента
                    newMyList[myList.length] = element;
                    myList = newMyList;
                }

                // поиск последнего элемента в массиве (если первоначальный массив ещё не заполнен
                else {
                    for (int i = 0; i < myList.length; i++) {
                        Optional<String> var = Optional.ofNullable(myList[i]);
                        if (var.isPresent()) {
                            continue;
                        } else {
                            myList[i] = element;
                            break;
                        }
                    }
                }

            }
            else if(input.equals("4")){
                System.out.println("4. Read list after increase.");

                System.out.println("Размер списка = " + myList.length);
                for (int i = 0; i < myList.length; i++) {
                    System.out.printf("%-10s %-10s %n", i, myList[i]);
                }

            }
            else if(input.equals("5")){
                //TODO
                System.out.println("5. Метод get by value.");


                String element = "";
                while(element.equals("")) {
                    System.out.println("Введите элемент списка:");
                    element = scn.nextLine();
                }

                // это костыль? index используется, чтобы сделать вывод на печать надписи, когда элемента нет в коллекции
                int index = 0;
                for (int i = 0; i < myList.length; i++) {
                    if(Optional.of(myList[i]).equals(element)){
                        System.out.println("Элемент " + element + " присутствует в коллекции под номером = " + i);
                        index++;
                    }
                }

                if(index == 0){
                    System.out.println("Элемент " + element + " отсутствует в коллекции");
                }

            }
            else if(input.equals("6")){
                System.out.println("6. Метод get by id.");
                System.out.println("Введите порядковый номер элемента списка:");
                String temp = scn.nextLine();
                int index = Integer.parseInt(temp);
                if(index < 0 || index > (myList.length - 1)){
                    System.out.println("Uncorrect input.");
                }else {
                    for (int i = 0; i < myList.length; i++) {
                        if(i == index){
                            if(Optional.ofNullable(myList[i]).isPresent()){
                                System.out.println("Под порядковым номером " + index + " в коллекции присутствует элемент = " + myList[i]);
                            }
                            else{
                                System.out.println("Ячейка под порядковым номером " + index + " в коллекции не заполнена");
                            }
                        }
                    }
                }
            }
            else if(input.equals("7")){
                System.out.println("7. Метод size.");
                System.out.println("Размер коллекции = " + myList.length);

            }
            else if(input.equals("8")){
                System.out.println("8. Метод contains.");
                System.out.println("Введите последовательность символов:");
                String temp = scn.nextLine();
                Optional<String> element = Optional.ofNullable(temp);
                System.out.println("Элементы, в который встречается последовательность символов " + temp + " :");

                int index = 0;

                if(element.isPresent()){
                    for (int i = 0; i < myList.length; i++) {
                        if(Optional.ofNullable(myList[i]).isPresent()){
                            if(myList[i].contains(temp)){
                                System.out.printf("%-10s %-10s %n", i, myList[i]);
                                index++;
                            }
                        }
                    }
                }

                if(index == 0){
                    System.out.println("Последовательность символов " + temp + " отсутствует в коллекции");
                }

            }
            else if(input.equals("9")){
                System.out.println("9. Метод indexOf.");
                System.out.println("Введите символ, поиск которого будет осуществляться в элементах списка:");
                String temp = scn.nextLine();
                Optional<String> element = Optional.ofNullable(temp);
                System.out.println("Элементы списка и номер позиции, на которой находится символ " + temp + " :");

                int index = 0;

                if(element.isPresent()){
                    for (int i = 0; i < myList.length; i++) {
                        if(Optional.ofNullable(myList[i]).isPresent()){
                            if(myList[i].indexOf(temp) >= 0){
                                System.out.printf("%-10s %-10s %n", myList[i], myList[i].indexOf(temp));
                                index++;
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }

                if(index == 0){
                    System.out.println("Символ " + temp + " отсутствует в коллекции");
                }

            }
            else if(input.equals("10")){
                System.out.println("10. Метод remove by Index.");
                System.out.println("Введите порядковый номер элемента списка:");
                String temp = scn.nextLine();
                int index = Integer.parseInt(temp);

                // проверяем, что индекс положительный и в границах размера списка
                if(index < 0 || index > (myList.length - 1)){
                    System.out.println("Uncorrect input.");
                }else {
                    for (int i = 0; i < myList.length; i++) {
                        if(i >= index & i <= (myList.length - 2)){
                            Optional <String> var = Optional.ofNullable(myList[i + 1]);
                            if(var.isPresent()){
                                myList[i] = var.get();
                            }else{
                                myList[i] = null;
                            }
                        }
                        // копирование последнего элемента
                        if(i == myList.length - 1){
                            myList[i] = null;
                        }
                    }
                }

            }
            else if(input.equals("11")){
                System.out.println("11. Метод remove by value.");
                System.out.println("Введите значение элемента списка:");
                String element = scn.nextLine();

                int index = -1;

                for (int i = 0; i < myList.length; i++) {
                    Optional <String> var = Optional.ofNullable(myList[i]);
                    if(var.isPresent()){
                        if(element.equals(myList[i])){
                            index = i;
                        }
                    }
                }

                if(index < 0){
                    System.out.println("Элемент " + element + " отсутствует в коллекции");
                }
                else{
                    for (int i = 0; i < myList.length; i++) {
                        if(i >= index & i <= (myList.length - 2)){
                            Optional <String> var = Optional.ofNullable(myList[i + 1]);
                            if(var.isPresent()){
                                myList[i] = var.get();
                            }else{
                                myList[i] = null;
                            }
                        }

                        if(i == myList.length - 1){
                            myList[i] = null;
                        }
                    }
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
