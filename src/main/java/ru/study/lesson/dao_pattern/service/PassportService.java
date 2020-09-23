package ru.study.lesson.dao_pattern.service;

import ru.study.lesson.dao_pattern.dao.Dao;
import ru.study.lesson.dao_pattern.dao.PassportDaoHibernateImpl;
import ru.study.lesson.dao_pattern.model.Passport;

import java.util.Scanner;

public class PassportService {
    public static void main(String[] args) {
//        DAO<Passport> dao = new PassportDAOFileImpl();
        Dao<Passport> dao = new PassportDaoHibernateImpl();

        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        while(userInput!=3){
            System.out.println("1. Добавить");
            System.out.println("2. Поиск по Id");
            System.out.println("3. Выход");
            userInput = scanner.nextInt();
            if(userInput == 1){
                Passport passport = new Passport(1, 123, 1234);
                dao.save(passport);
            }else if(userInput == 2){
                int inputId = 1;
                Passport ps = dao.getById(inputId);
                System.out.println(ps.toString());
            }
        }


    }
}
