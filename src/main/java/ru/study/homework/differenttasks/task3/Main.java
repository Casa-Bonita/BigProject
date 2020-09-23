package ru.study.homework.differenttasks.task3;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        Operations oper = new Operations();

        Random rnd = new Random();

//3. Написать рекурсивный метод, возвращающий сумму цифр числа n. Под суммой цифр подразумевается сумма чисел от 0 до n включительно.
		int n = rnd.nextInt(99) + 1;
		oper.printPrepare("Автоматически сгенерировано число n = ");
        System.out.println(n);
        oper.printPrepare("Сумма чисел от 0 до " + n + " = ");
        System.out.println(oper.summa(n));
        System.out.println();

//4. Написать метод, который рекурсивно выводит символы из строки в прямом порядке.
		String str = "Я люблю тебя жизнь, что само по себе и не ново";
        oper.printPrepare(str);
        System.out.println("\n");

// 5. Написать рекурсивный метод, возвращающий слово «yes», если число n является точной степенью двойки, иначе - слово «no».
        while(true){
            n = rnd.nextInt(998) + 2;
            oper.printPrepare("Сгенерировано число = ");
            System.out.println(n);
            if((n % 2) == 0){
                oper.printPrepare("Число ");
                System.out.print(n);
                oper.printPrepare(" является точной степенью двойки: ");
                System.out.println(oper.degree(n));
                break;
            }
            oper.printPrepare("Число ");
            System.out.print(n);
            oper.printPrepare(" является нечётным. Поэтому будет проведена повторная генерация числа.");
            System.out.print("\n");
        }

// 6. Написать метод, который выводит n первых чисел из последовательности Фибоначчи.
        n = rnd.nextInt(39) + 1;
        System.out.println("\n");
        oper.printPrepare("Автоматически сгенерировано число n = ");
        System.out.println(n);
        if (n == 1 || n == 2){
            System.out.print(n);
            oper.printPrepare(" первых чисел из последовательности Фибоначчи: 1");
        }else {
            oper.fibo(n, 1);
        }

    }
}
