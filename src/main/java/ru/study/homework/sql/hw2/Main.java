package ru.study.homework.sql.hw2;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {


//        Создать таблицы Human и Passport с отношением один к одному. У одного человека может быть только один паспорт.
//        Таблица Human должна иметь как минимум следующие столбцы:
//        - id (primary key, auto increment);
//        - имя;
//        - фамилия;
//        - возраст.
//
//        Таблица Passport должна иметь как минимум следующие столбцы:
//        - id (primary key, auto increment);
//        - серия;
//        - номер;
//        - гражданство.
//
//        Связать таблицы отношением один ко многим через внешний ключ.
//
//        В main сделать консольное меню:
//        1. Добавить человека;
//        2. Добавить паспорт;
//        3. Связать человека и паспорт;
//        4. Вывести имя, фамилию, возраст, серию и номер паспорта каждого человека;
//        5. Вывести гражданство человека по имени и фамилии;
//        6. Вывести имена и фамилию только граждан РФ;
//        7. Найти человека по серии и номеру паспорта;
//        8. Выход.

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/citizens", "root", "");
        Statement stmt = connection.createStatement();

        Scanner scn = new Scanner(System.in);
        String input = "";

        while(!input.equals("10")) {
            System.out.println();
            System.out.println("1. Добавить человека.");
            System.out.println("2. Добавить паспорт.");
            System.out.println("3. Связать человека и паспорт.");
            System.out.println("4. Вывести имя, фамилию, возраст, серию и номер паспорта каждого человека.");
            System.out.println("5. Вывести гражданство человека по имени и фамилии.");
            System.out.println("6. Вывести имена и фамилию только граждан РФ.");
            System.out.println("7. Найти человека по серии и номеру паспорта.");
            System.out.println("8. Вывод информации о всех гражданах.");
            System.out.println("9. Вывод информации о всех паспортах.");
            System.out.println("10. Выход.");

            input = scn.nextLine();
            if (input.equals("1")) {
                System.out.println("1. Добавить человека.");
                System.out.println("Введите имя человека:");
                String inputName = scn.nextLine();
                System.out.println("Введите фамилию человека:");
                String inputSurname = scn.nextLine();
                System.out.println("Введите возраст человека:");
                int inputAge = Integer.valueOf(scn.nextLine());

                String query = "INSERT INTO human (human_name, human_surname, human_age) VALUES ('" + inputName + "', '" + inputSurname + "', " + inputAge + ")";

                stmt.executeUpdate(query);
                System.out.println("Новый человек добавлен в базу.");

            } else if (input.equals("2")) {
                System.out.println("2. Добавить паспорт.");
                System.out.println("Введите серию паспорта:");
                int inputSeries = Integer.valueOf(scn.nextLine());
                System.out.println("Введите номер паспорта:");
                int inputNumber = Integer.valueOf(scn.nextLine());
                System.out.println("Введите гражданство:");
                String inputCitizenship = scn.nextLine();

                String query = "INSERT INTO passport (passport_series, passport_number, passport_citizenship) VALUES (" + inputSeries + ", " + inputNumber + ", '" + inputCitizenship + "')";

                stmt.executeUpdate(query);
                System.out.println("Новый паспорт добавлен в базу.");

            } else if (input.equals("3")) {
                // Структура действий поэтапно:
                // 1. Получаем таблицу со списком людей, у которых нет "привязки" к паспорту и списком паспортов, у которых нет привязки к человеку
                // 2. Из полученного списка определяем human_id и passport_id
                // 3. Делаем запрос в таблицу passport, где для необходимого паспорта (passport_id) устанавливаем human_id

                System.out.println("3. Связать человека и паспорт.");


                // 1. Получаем таблицу со списком людей, у которых нет "привязки" к паспорту и списком паспортов, у которых нет привязки к человеку
                String query = "SELECT human.human_id, human_name, human_surname, passport_id, passport_series, passport_number, passport_citizenship FROM human RIGHT JOIN passport ON human.human_id = passport.human_id" +
                                " UNION" +
                                " SELECT human.human_id, human_name, human_surname, passport_id, passport_series, passport_number, passport_citizenship FROM human LEFT JOIN passport ON human.human_id = passport.human_id";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", "Human_ID", "Имя", "Фамилия", "ID паспорта", "Серия паспорта", "Номер паспорта", "Гражданство");
                while(rs.next()) {
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %n", rs.getInt("human_id"), rs.getString("human_name"), rs.getString("human_surname"),
                            rs.getInt("passport_id"), rs.getInt("passport_series"), rs.getInt("passport_number"), rs.getString("passport_citizenship"));
                }


                // 2. Из полученного списка определяем необходимый human_id и passport_id
                System.out.println("Введите ID человека, которому необходимо \"привязать\" паспорт:");
                int inputHumanID = Integer.valueOf(scn.nextLine());

                System.out.println("Введите ID паспорта, который необходимо \"привязать\" к человеку:");
                int inputPassportID = Integer.valueOf(scn.nextLine());


                // 3. Делаем запрос в таблицу passport, где для необходимого паспорта (passport_id) устанавливаем human_id

                query = "UPDATE passport SET human_id = " + inputHumanID + " WHERE passport.passport_id = " + inputPassportID + "";

                stmt.executeQuery(query);
                System.out.println("Паспорт \"привязан\" к человеку.");

            } else if (input.equals("4")) {
                System.out.println("4. Вывести имя, фамилию, возраст, серию и номер паспорта каждого человека.");

                String query = "SELECT human_name, human_surname, human_age, passport_series, passport_number FROM human INNER JOIN passport ON human.human_id = passport.human_id";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", "Имя", "Фамилия", "Возраст", "Серия паспорта", "Номер паспорта");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", rs.getString("human_name"), rs.getString("human_surname"),
                            rs.getInt("human_age"), rs.getInt("passport_series"), rs.getInt("passport_number"));
                }

            } else if (input.equals("5")) {
                System.out.println("5. Вывести гражданство человека по имени и фамилии.");
                System.out.println("Введите имя человека:");
                String inputName = scn.nextLine();
                System.out.println("Введите фамилию человека:");
                String inputSurname = scn.nextLine();

                String query = "SELECT passport_citizenship FROM human INNER JOIN passport ON human.human_id = passport.human_id WHERE human.human_name = '"+inputName+"' AND human.human_surname = '"+inputSurname+"'";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %n","Имя", "Фамилия", "Гражданство");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %n", inputName, inputSurname, rs.getString("passport_citizenship"));
                }

            } else if (input.equals("6")) {
                System.out.println("6. Вывести имена и фамилию только граждан РФ.");

                String query = "SELECT human_name, human_surname, passport.passport_citizenship FROM human INNER JOIN passport ON human.human_id = passport.human_id WHERE passport.passport_citizenship = 'russian'";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %n", "Имя", "Фамилия", "Гражданство");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %n", rs.getString("human_name"), rs.getString("human_surname"), rs.getString("passport_citizenship"));
                }

            } else if (input.equals("7")) {
                System.out.println("7. Найти человека по серии и номеру паспорта.");
                System.out.println("Введите серию паспорта:");
                int inputSeries = Integer.valueOf(scn.nextLine());
                System.out.println("Введите номер паспорта:");
                int inputNumber = Integer.valueOf(scn.nextLine());

                String query = "SELECT human_name, human_surname, passport_series, passport_number FROM human INNER JOIN passport ON human.human_id = passport.human_id WHERE passport.passport_series = '"+inputSeries+"' AND passport.passport_number = '"+inputNumber+"'";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %-20s %n", "Имя", "Фамилия", "Серия паспорта", "Номер паспорта");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %-20s %n", rs.getString("human_name"), rs.getString("human_surname"), rs.getInt("passport_series"), rs.getInt("passport_number"));
                }

            } else if (input.equals("8")) {
                System.out.println("8. Вывод информации о всех гражданах.");

                String query = "SELECT * FROM human";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %-20s %n", "ID человека", "Имя", "Фамилия", "Возраст");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %-20s %n", rs.getInt("human_id"), rs.getString("human_name"), rs.getString("human_surname"), rs.getInt("human_age"));
                }

            } else if (input.equals("9")) {
                System.out.println("9. Вывод информации о всех паспортах.");

                String query = "SELECT * FROM passport";

                ResultSet rs = stmt.executeQuery(query);
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", "Паспорт ID", "Серия", "Номер", "Гражданство", "Human_ID");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %n", rs.getInt("passport_id"), rs.getInt("passport_series"), rs.getInt("passport_number"),
                            rs.getString("passport_citizenship"), rs.getInt("passport.human_id"));
                }

            } else if (input.equals("10")) {
                System.out.println("10. Выход.");
                System.out.println("Программа завершила свою работу.");

            } else {
                System.out.println("Некорректный ввод.");

            }
        }
    }
}
