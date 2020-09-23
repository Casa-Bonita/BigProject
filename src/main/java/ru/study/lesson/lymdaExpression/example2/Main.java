package ru.study.lesson.lymdaExpression.example2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //сделать два типа приветствия: приветствие человеческое (hello!) и приветствие робота (010101)

        Scanner scn = new Scanner(System.in);
        System.out.println("Who are you?");
        String answ = scn.next();
        if(answ.equals("human")){
            greeting(()-> System.out.println("hello"));
        }else{
            greeting(()-> System.out.println("010101"));
        }


    }

    public static void greeting(Greeting greeting){
        greeting.greet();
    }
}
