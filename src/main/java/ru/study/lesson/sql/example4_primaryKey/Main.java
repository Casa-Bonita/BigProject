package ru.study.lesson.sql.example4_primaryKey;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cardealership", "root", "");
//        Statement stmt = connection.createStatement();
//        String query = "INSERT INTO car2 (automaker, model, amount) VALUES('BMW', 'M5', 10)";
//        int count = stmt.executeUpdate(query);
//        System.out.println("changed: "+count+" rows");


//        String query = "DELETE FROM car2 where id = 2";
//        System.out.println(insertRemoveUpdateQuery(query));
//        query = "INSERT INTO car2 (automaker, model, amount) VALUES('Lada', 'VESTA', 20)";
//        System.out.println(insertRemoveUpdateQuery(query));
//

        //Вывести имя владельца и название автомобиля, которым он владеет
        //String cardId = "SELECT id FROM car2 WHERE "
        String query = "SELECT ch.name, c.automaker, c.model from carholder ch, car2 c where ch.name='Ivan' and  ch.car2_id=c.id";
        /*
        1 Ivan Q7
        2 Ivan Q5
        1 Ivan Q5
        2 Ivan Q7
         */
        ResultSet rs = selectQuery(query);
        while(rs.next()){
            System.out.println(rs.getString("name")+" "+rs.getString("automaker")+" "+rs.getString("model"));
        }
    }

    public static int insertRemoveUpdateQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cardealership", "root", "");
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }


    public static ResultSet selectQuery(String query) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/cardealership", "root", "");
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);

    }

}
