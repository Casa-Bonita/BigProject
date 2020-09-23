package ru.study.homework.json.task2;

import java.sql.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws SQLException {

//    2. Создать таблицы Склад и Товар. На складе может лежать много товаров. Каждый товар одновременно может лежать только на одном складе.
//    Каждый Склад характеризуется полями:
//    - адрес.
//
//    Каждый Товар характеризуется полями:
//    - название;
//    - адрес доставки.
//
//    В main создать список складов и консольное меню:
//    1. Вывести все товары со склада (вводится индекс конкретного склада);
//    2. Выполнить поиск товара (результат - адрес склада, на котором находится товар);
//    3. Добавить товар (программа запрашивает индекс склада, куда добавить товар);
//    4. Вывести склады (выводит индекс и адрес складов);
//    5. Выход.
//
//    Можно добавлять свои столбцы в таблицы, названия товаров не должны дублироваться при их комбинировании со складом.

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/products", "root", "");
        Statement stmt = connection.createStatement();

        Scanner scn = new Scanner(System.in);
        String input = "";

        while(!input.equals("5")){
            System.out.println("1. Вывести все товары со склада (вводится индекс конкретного склада).");
            System.out.println("2. Выполнить поиск товара (результат - адрес склада, на котором находится товар).");
            System.out.println("3. Добавить товар (программа запрашивает индекс склада, куда добавить товар).");
            System.out.println("4. Вывести склады (выводит индекс и адрес складов).");
            System.out.println("5. Выход.");

            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Вывести все товары со склада (вводится индекс конкретного склада).");
                System.out.println("Выберите склад:");

                String query = "SELECT * FROM sklad ORDER BY sklad_id";

                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID склада", "Адрес склада");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("sklad_id"), rs.getString("sklad_address"));
                }
                System.out.println("Введите ID склада:");
                int inputSkladID = Integer.valueOf(scn.nextLine());

                query = "SELECT t.tovar_id, t.tovar_name FROM tovar t INNER JOIN relation r ON t.tovar_id = r.tovar_id INNER JOIN sklad s ON r.sklad_id = s.sklad_id WHERE s.sklad_id = '" + inputSkladID + "' ORDER BY t.tovar_name";

                rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID товара", "Наименование товара");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("tovar_id"), rs.getString("tovar_name"));
                }

            }else if(input.equals("2")){
                System.out.println("2. Выполнить поиск товара (результат - адрес склада, на котором находится товар).");
                System.out.println("Выберите товар:");

                String query = "SELECT * FROM tovar ORDER BY tovar_name";

                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID товара", "Наименование товара");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("tovar_id"), rs.getString("tovar_name"));
                }
                System.out.println("Введите ID товара:");
                int inputTovarID = Integer.valueOf(scn.nextLine());

                query = "SELECT s.sklad_address FROM tovar t INNER JOIN relation r ON t.tovar_id = r.tovar_id INNER JOIN sklad s ON r.sklad_id = s.sklad_id WHERE t.tovar_id = '" + inputTovarID + "'";

                rs = stmt.executeQuery(query);

                System.out.printf("Товар находится на складе:");
                while(rs.next()){
                    System.out.printf("%-20s %n", rs.getString("sklad_address"));
                }


            }else if(input.equals("3")){
                System.out.println("3. Добавить товар (программа запрашивает индекс склада, куда добавить товар).");
                System.out.println("Введите название товара:");
                String inputTovarName = scn.nextLine();

                System.out.println("Введите адрес доставки:");
                String inputDeliveryAddress = scn.nextLine();

                String query = "INSERT INTO tovar (tovar_name, delivery_address) VALUES ('" + inputTovarName + "', '" + inputDeliveryAddress + "')";
                stmt.executeUpdate(query);

                System.out.println("Товар добавлен в базу данных.");

                System.out.println("Выберите склад, на котором будет храниться товар:");

                query = "SELECT * FROM sklad ORDER BY sklad_id";
                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID склада", "Адрес склада");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("sklad_id"), rs.getString("sklad_address"));
                }

                System.out.println("Введите ID склада:");
                int inputSkladID = Integer.valueOf(scn.nextLine());

                query = "SELECT COUNT(tovar_id) FROM tovar";

                rs = stmt.executeQuery(query);

                int temp = rs.getInt("COUNT(tovar_id)");

                query = "INSERT INTO relation (tovar_id, sklad_id) VALUES (" + temp + ", " + inputSkladID + ")";
                stmt.executeUpdate(query);

            }else if(input.equals("4")){
                System.out.println("4. Вывести склады (выводит индекс и адрес складов).");

                String query = "SELECT * FROM sklad ORDER BY sklad_id";
                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID склада", "Адрес склада");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("sklad_id"), rs.getString("sklad_address"));
                }

            }else if(input.equals("5")){
                System.out.println("5. Выход.");

            }else{
                System.out.println("Некорректный ввод.");

            }
        }

    }
}
