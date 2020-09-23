package ru.study.lesson.sql.example3_update_delete;

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
        //Для выполения Update, Delete нужен метод executeUpdate, который возвращает не ResultSet объект, а количество изменнных строк
        String query = "UPDATE tovar SET price = 85 WHERE name = 'Iphone 8'";
        System.out.println(query);
        stmt.executeUpdate(query);

        query = "DELETE FROM tovar WHERE name = 'IPhone 8'";
        System.out.println(stmt.executeUpdate(query));


    }
}
