package ru.study.homework.multithreading.task4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//    TEST 4 - START
//    4. Создать консольное меню:
// 1. Записать в файл большой объем данных
// 2. Тренировка логики (при запуске программа выводит два случайных числа и пользователь должен ввести их сумму.
//     Программа отвечает: правильно или неправильно. И так 5 раз подряд.)
// 3. Выход
//
// Программа должна выполнять две задачи: запись данных в файл (предположим, это занимает до 10 секунд) и игра на тренировку логики.
// Чтобы пользователь мог выполнять эти две задачи одновременно, нужно разделить их на два потока.
// Сделайте так, чтобы запись в файл выполнялась в отдельном потоке и занимала 10 секунд с использованием Thread.sleep.
// (Совсем не обязательно создавать большой объем данных. Главное - сымитировать задачу с большой длительностью.
// Можно записать всего две строки и сделать паузу между ними в 5 секунд).
// После того, как пользователь запустит запись в файл, он может выбрать второй пункт из меню и сыграть в игру.
// Когда данные запишутся в файл, программа должна вывести сообщение в консоль "Данные записаны".

        Scanner scn = new Scanner(System.in);
        Random rnd = new Random();

        int input = 0;
        int humanResult = 0; // результат операции в формате int
        while(input != 3){
            System.out.println("\n" + "Выберите пункт меню:");
            System.out.println("1. Запись файла с данными.");
            System.out.println("2. Тренировка логики.");
            System.out.println("3. Выход.");
            input = scn.nextInt();
            if(input == 1){
                MyThread myThread = new MyThread();
                new Thread(myThread).start();

            }else if (input == 2){
                int i = 1;
                while (i != 6) {
                    int a = rnd.nextInt(50);
                    int b = rnd.nextInt(50);
                    int programResult = a + b;
                    System.out.println("\n" + "Попытка № " + i);
                    System.out.println("A = " + a + "\n" + "B = " + b);
                    System.out.println("Введите результат сложения чисел \"A\" и \"B\":");

                    humanResult = scn.nextInt();

                    if (humanResult != programResult) {
                        System.out.println("Вы ввели неверный ответ");
                    } else {
                        System.out.println("Сумма посчитана верно!!!");
                    }
                    i++;
                }

            }else if (input == 3){
                System.out.println("Программа завершила свою работу.");

            }else{
                System.out.println("Некорректный ввод.");
            }
        }

    }
}
