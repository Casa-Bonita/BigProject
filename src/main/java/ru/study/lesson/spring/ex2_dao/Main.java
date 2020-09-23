package ru.study.lesson.spring.ex2_dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.study.lesson.spring.ex2_dao.config.Config;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Scanner scn = new Scanner(System.in);
        String inputMethod = "";

        InputBook inputBook = context.getBean(InputBook.class);

        while (!inputMethod.equals("3")) {
            System.out.println("1. Select Book.");
            System.out.println("3. Exit.");
            inputMethod = scn.nextLine();

            if (inputMethod.equals("1")) {
                inputBook.inputBook();

            }  else if (inputMethod.equals("3")) {
                System.out.println("3. Exit.");

            } else {
                System.out.println("Uncorrect input.");

            }
        }


//        Scanner scn = new Scanner(System.in);
//        String inputMethod = "";
//
//        while (!inputMethod.equals("3")) {
//            System.out.println("1. Select Book.");
//            System.out.println("3. Exit.");
//            inputMethod = scn.nextLine();
//
//            if (inputMethod.equals("1")) {
//                InputBook ib = new InputBook();
//                ib.inputBook();
//
//            }  else if (inputMethod.equals("3")) {
//                System.out.println("3. Exit.");
//
//            } else {
//                System.out.println("Uncorrect input.");
//
//            }
//        }


    }
}
