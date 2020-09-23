package ru.study.homework.json.task6;

public class Operations {

    // содержит метод конвертации числа val в строку String
    public static String convert (int val){
        String line = String.valueOf(val);
        return line;
    }

    public static double pow (double val, int pow){
        double result = 1.0;
        for (int i = 0; i < pow; i++) {
            result = result * val;
        }
        return result;
    }

    public static void printString (String text){
        System.out.println(text);
    };
}

