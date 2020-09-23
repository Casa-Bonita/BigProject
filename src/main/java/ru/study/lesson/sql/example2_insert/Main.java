package ru.study.lesson.sql.example2_insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        //создали подключение к БД
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tovardb", "root", "");
        //создаем statement, который позволит выполнить запрос к БД
        Statement stmt = connection.createStatement();
        //Для выполения Insert нужен метод executeUpdate, который возвращает не ResultSet объект, а количество изменнных строк
        String query = "INSERT INTO tovar (name, price) VALUES('Iphone 8', 80)";
        System.out.println(query);
        stmt.executeUpdate(query);



    }
}
