package ru.study.homework.multithreading.task2;

import java.util.*;


public class DataSource {
    Random rnd = new Random();
    Scanner scn = new Scanner(System.in);

    private String y; // String считываемые с консоли
    private int x; // преобразование в int

// Ввод данных с консоли тип String и конвертация в int
    public int inputconvert (int number){
        try {
            System.out.println("Введите число " + number + ":");
            y = scn.nextLine();
            x = Integer.valueOf(y);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введенные данные \"" + y + "\" не являются числом.");
            System.out.println("Числу " + number + " присвоено значение 0.");
            x = 0;
        }
        return x;
    }

// Генерация случайного целого числа
    public int generate (){
        int x = rnd.nextInt(100);
        return x;
    }
}
