package ru.study.lesson.exception.example1;

public class Main {
    public static void main(String[] args) {
        //создание собственных исключений
        //создать метод расчета факториала числа, который будет генерировать исключение InvalidValueException, если число факториала меньше нуля

        print(-2);
    }
    static void print(int val){
        if(val<=0)
            throw new InvalidValueException("база факториала меньше либо равна нулю");
        int res = 1;
        for (int i = val; i >1 ; i--) {
            res = res * i;
        }
        System.out.println(res);
    }
}
