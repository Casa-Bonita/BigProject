package ru.study.lesson.sql.practice1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Создать консольное меню:
        /*
        1. Вывести список всех товаров
        2. Изменть цену
        3. Удаление товара по названию
        4. Добавить новый товар
        5. Выход

         */

        //создали подключение к БД
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tovardb", "root", "");
        //создаем statement, который позволит выполнить запрос к БД
        Statement stmt = connection.createStatement();

        String input = "";
        Scanner scn = new Scanner(System.in);
        while(!input.equals("5")){
            System.out.println("1. Вывести список всех товаров");
            System.out.println("2. Изменть цену");
            System.out.println("3. Удаление товара по названию");
            System.out.println("4. Добавить новый товар");
            System.out.println("5. Выход");
            input = scn.nextLine();
            if(input.equals("1")){
                String query = "SELECT * from tovar";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    System.out.println(rs.getString("name") + " " + rs.getDouble("price"));
                }

            }else if(input.equals("2")){
                System.out.println("Введите название товара");
                String name = scn.nextLine();
                String query = "SELECT * from tovar WHERE name = '"+name+"'";
                //SELECT * from tovar WHERE name = 'Iphone 11'
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from tovar WHERE name = ?");
                preparedStatement.setString(1, name);
                ResultSet rs = preparedStatement.executeQuery();
                try {
                    rs.next();
                    Tovar tovar = new Tovar(rs.getString("name"), rs.getDouble("price"));
                    System.out.println(tovar);
                    System.out.println("Какую цену поставить?");
                    double newPrice = Double.valueOf(scn.nextLine());
                    query = "UPDATE tovar SET price = " + newPrice + " WHERE name = '" + name + "'";
                    stmt.executeUpdate(query);
                }catch(Exception e){
                    System.out.println("Товар не найден");
                }
//                System.out.println("Введите название товара");
//                String name = scn.nextLine();
//                String query = "SELECT * from tovar WHERE name = '"+name+"'";
//                //SELECT * from tovar WHERE name = 'Iphone 11'
//                ResultSet rs = stmt.executeQuery(query);
//
//                try {
//                    rs.next();
//                    Tovar tovar = new Tovar(rs.getString("name"), rs.getDouble("price"));
//                    System.out.println(tovar);
//                    System.out.println("Какую цену поставить?");
//                    double newPrice = Double.valueOf(scn.nextLine());
//                    query = "UPDATE tovar SET price = " + newPrice + " WHERE name = '" + name + "'";
//                    stmt.executeUpdate(query);
//                }catch(Exception e){
//                    System.out.println("Товар не найден");
//                }
            }
            else if(input.equals("3")){
                System.out.println("Введите название товара");
                String name = scn.nextLine();
                String query = "SELECT * from tovar WHERE name = '"+name+"'";
                ResultSet rs = stmt.executeQuery(query);
                try {
                    rs.next();
                    Tovar tovar = new Tovar(rs.getString("name"), rs.getDouble("price"));
                    System.out.println(tovar);
                    query = "DELETE FROM tovar WHERE name = '" + name + "'";
                    stmt.executeUpdate(query);
                    System.out.println("Товар удалён");

                }catch(Exception e){
                    System.out.println("Товар не найден");
                }

            }
            else if(input.equals("4")){
                System.out.println("Введите название товара");
                String name = scn.nextLine();
                System.out.println("Введите цену товара");
                try{
                    double price = Double.valueOf(scn.nextLine());
                    String query = "INSERT INTO tovar (name, price) VALUES('" + name + "', " + price + ")";
                    stmt.executeUpdate(query);
                    System.out.println("Товар добавлен");
                } catch (Exception e){
                    System.out.println("Некорректный ввод");
                }

            }
            else if(input.equals("5")){
                System.out.println("Программа завершила свою работу.");
                break;

            }else{
                System.out.println("Некорректный ввод.");
            }

        }
    }
}
