package ru.study.lesson.enum_lesson;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1. Создать enum Week с константами в виде дней недели. Добавить константам псеводними на русском языке. В мейне вывести все константы из enum через метод values.

        Week week = Week.Monday;
        System.out.println(week);
        System.out.println(week.getName());


        //Определить день недели в виде enum, который ввел пользователь с консоли для решения проблем опечатками.
        //То есть юзер что-то вводит, смотрим, есть ли данный день среди констант у enum и если находим, то возвращаем эту константу


        //Создать объек класса WeekPlan на основе данных с консоли
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter day name");
        String dayName = scn.next();
        System.out.println("Enter plans");
        String plans = scn.next();

        WeekPlan weekPlan = null;
        //Способ 1
        //получаем массив всех констант из Enum и перебираем их в цикле
//        Week[] values = Week.values();
//        for (int i = 0; i < values.length; i++) {
//            if(values[i].getName().equals(dayName)){
//                weekPlan = new WeekPlan(values[i], plans);
//                break;
//            }
//        }
//
//        if(weekPlan==null){
//            System.out.println("День недели "+dayName+" не существует");
//        }else{
//            System.out.println(weekPlan);
//        }



        //Способ 2
        //через созданный метод в самом enum
        //Week week1 = Week.findWeekDay(dayName).orElseThrow(() -> new RuntimeException("День недели " + dayName + " не существует"));
        Optional<Week> weekDayOpt = Week.findWeekDay(dayName);
        if(weekDayOpt.isPresent()){
            weekPlan = new WeekPlan(weekDayOpt.get(), plans);
            System.out.println(weekPlan);
        }else{
            System.out.println("День недели не найден");
        }

        System.out.println("finish");




    }

}
