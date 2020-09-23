package ru.study.lesson.sql.example1_select;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    //jdbc driver (jdbc connector) - набор классов и команд для работы с БД (любой БД)
    public static void main(String[] args) throws SQLException {
        //создали подключение к БД
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tovardb", "root", "");
        //создаем statement, который позволит выполнить запрос к БД
        Statement stmt = connection.createStatement();
        //выполняем запрос, который возвращает результаты запроса в виде объекта ResultSet
        //для выплонения select запроса нужен метод executeQuery, так как он возвращает результаты запроса
        ResultSet rs = stmt.executeQuery("SELECT * FROM tovar");
        //достаем из ResultSet результаты (строки)
        //next смещает указатель итератора на следующий элемент. Если элемента нет, то next возвращает false
        List<Tovar> tovars = new ArrayList<>();
        while(rs.next()){
            //достаем под текущим указателем значения из объекта rs
            //System.out.println(rs.getString("name")+" "+rs.getDouble("price"));
            tovars.add(new Tovar(rs.getString("name"), rs.getDouble("price")));
        }

        System.out.println(tovars);




    }
}
