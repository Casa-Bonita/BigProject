package ru.study.homework.json.task6;

import ru.study.homework.synchro.task3.Operation;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

//    6. Создать интерфейсы:
//
//    //содержит метод вывода строки на консоль
//    interface Print{
//        void printString(String text);
//    }
//
//    //содержит метод возведения числа val в степень pow
//    interface Pow{
//        double pow(double val, int pow);
//    }
//
//    //содержит метод конвертации числа val в строку String
//    interface Convert{
//        String convert(int val);
//    }
//
//    В main создать ссылки на методы для этих интерфейсов и вызвать эти методы.


        Random rnd = new Random();

        Operations oper = new Operations();

//        Convert c = oper::convert;
        Convert c = Operations::convert;
        System.out.println("Конвертация числа в строку");
        System.out.println("Вывод в виде строки: " + c.convert(25) + "\n");


        double val = rnd.nextDouble() + 1;
        int pow = rnd.nextInt(9) + 1;

//        Pow p = oper::pow;
        Pow p = Operations::pow;
        System.out.println("Возведение числа = " + val + " в степень = " + pow + ", результат = " + p.pow(val, pow) + "\n");

//        Print pr = oper::printString;
        Print pr = Operations::printString;
        String text = "Good morning, Vietnam!";
        System.out.println("Печатается текст:");
        pr.printString(text);
    }
}
