package ru.study.lesson.dao_pattern;

import ru.study.lesson.dao_pattern.model.User;
import ru.study.lesson.dao_pattern.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //DAO паттерн
        //Хранение данных о паспортах в файле


        //model Хранит исходные данные - класс Passport

        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        while(userInput!=3){
            System.out.println("1. Добавить");
            System.out.println("2. Поиск по Id");
            System.out.println("3. Выход");
            userInput = scanner.nextInt();
            if(userInput == 1){
                User user = new User(1, "Ivan", 34);
                userService.save(user);
            }else if(userInput == 2){
                int inputId = 1;
                User us = userService.getById(inputId);
                System.out.println(us.toString());
            }
        }
    }
}
