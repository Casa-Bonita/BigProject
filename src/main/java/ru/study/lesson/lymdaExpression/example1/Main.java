package ru.study.lesson.lymdaExpression.example1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Action action = new Action() {
//            @Override
//            public void print() {
//                System.out.println("hello world");;
//            }
//        };
//        action.print();

        //лямбда выражение - сокращенный способ создания анонимных классов на основе интерфейсов, имеющих один метод
//        Action action = ()-> System.out.println("hello world");
//        action.print();

        //лямбда выражение может содержать не только одну строку
//        Action action = ()-> {
//            Scanner scn = new Scanner(System.in);
//            System.out.println("Enter value");
//            System.out.println("you entered: "+scn.next());
//        };
//        action.print();


        //лямда выражение на основе метода с параметрами
//        Calc sum = (double x, double y)-> System.out.println(x+y);
//        sum.doSome(2,4);

        //тип данных для параметров в лямбда выраж-ии писать не обязательно
        //сокращенная форма:
//        Calc sum = (x, y)-> System.out.println(x+y);
//        sum.doSome(2,4);

        //лямбда выражения на основе метода с возвращаемым значением
//        CalcWithReturn minus = (x, y)-> {
//            return x-y;
//        };
        //В сокращенной версии return опускается (его уже нельзя использовать)
//        CalcWithReturn minus = (x, y)-> x-y;
//        System.out.println(minus.doSome(2, 4));


    }
}
