package ru.study.lesson.exception.practice1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //написать калькулятор с действия + и -. Если пользователь вводит другой знак, то генерируется исключения (checked) InvalidSignException
        Scanner scn = new Scanner(System.in);

        int a = 5;
        int b = 10;
        String input = "";
        System.out.println("Введите знак операции");
        input = scn.nextLine();

        if(!input.equals("+") && !input.equals("-")){
            try{
                throw new InvalidSignException(input);
            }
            catch (InvalidSignException e){
                System.out.println(e.toString());
                System.out.println("Введите корректный знак");
                //e.printStackTrace();

            }


        }
    }
}
