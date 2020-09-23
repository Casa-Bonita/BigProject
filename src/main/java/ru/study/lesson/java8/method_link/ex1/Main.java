package ru.study.lesson.java8.method_link.ex1;

public class Main {
    public static void main(String[] args) {
        //Ссылки на методы
//        Calc calc = new Calc() {
//            @Override
//            public int makeCalc(int a, int b) {
//                return a+b;
//            }
//        };

        //Calc calc = (a,b)->a+b;
        //Calc calc = (a,b)->sum(a,b);
        Calc calc = Main::sum;
        System.out.println(calc.makeCalc(2, 3));

    }

    public static int sum(int a, int b){
        return a+b;
    }
}
