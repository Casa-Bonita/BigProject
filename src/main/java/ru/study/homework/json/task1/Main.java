package ru.study.homework.json.task1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

//    1. Создать таблицы Предмет и Студент. У одного студента может быть много предметов, в то же время один и тот же предмет может быть у многих студентов.
//    Каждый предмет характеризуется полями:
//    - название;
//    - длительность курса.
//
//    Каждый студент характеризуется полями:
//    - имя;
//    - курс.
//
//    В main создать список студентов и консольное меню:
//    1. Вывести всех студентов и их предметы;
//    2. Добавить студенту предмет;
//    3. Добавить студента;
//    4. Добавить предмет;
//    5. Выход.
//
//    Названия предметов и имена студентов не должны дублироваться при их комбинировании.

        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/university", "root", "");
        Statement stmt = connection.createStatement();

        Scanner scn = new Scanner (System.in);
        String input = "";

        while(!input.equals("5")){
            System.out.println("1. Список всех студентов, с указанием предметов.");
            System.out.println("2. Добавление студенту предмета.");
            System.out.println("3. Добавление студента.");
            System.out.println("4. Добавление предмета.");
            System.out.println("5. Выход.");

            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Список всех студентов, с указанием предметов.");

                String query =
                "SELECT st.student_name, COUNT(su.subject_name) AS subjects_amount, GROUP_CONCAT(su.subject_name) AS subjects FROM student st INNER JOIN relation re ON st.student_id = re.student_id " +
                        "INNER JOIN subject su ON re.subject_id = su.subject_id GROUP BY st.student_name ORDER BY st.student_id";
                System.out.println(query);
                //"SELECT st.student_name, su.subject_name FROM student st INNER JOIN relation re ON st.student_id = re.student_id INNER JOIN subject su ON re.subject_id = su.subject_id ORDER BY st.student_id";

                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %-20s %n", "Студент", "Количество предметов", "Перечень предметов");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %-20s %n", rs.getString("student_name"), rs.getInt("subjects_amount"), rs.getString("subjects"));
                }

            }else if(input.equals("2")){
                System.out.println("2. Добавление студенту предмета.");
                System.out.println("Выберите студента:");

                String query = "SELECT student_id, student_name FROM student ORDER BY student_name";

                ResultSet rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID студента", "Студент");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("student_id"), rs.getString("student_name"));
                }
                System.out.println("Введите ID студента:");
                int inputStudentID = Integer.valueOf(scn.nextLine());

                System.out.println("Выберите предмет:");
                query = "SELECT subject_id, subject_name FROM subject ORDER BY subject_name";

                rs = stmt.executeQuery(query);

                System.out.printf("%-20s %-20s %n", "ID предмета", "Название предмета");
                while(rs.next()){
                    System.out.printf("%-20s %-20s %n", rs.getInt("subject_id"), rs.getString("subject_name"));
                }
                System.out.println("Введите ID предмета:");
                int inputSubjectID = Integer.valueOf(scn.nextLine());

                query = "INSERT INTO relation (student_id, subject_id) VALUES (" + inputStudentID + ", " + inputSubjectID + ")";
                stmt.executeUpdate(query);

            }else if (input.equals("3")){
                System.out.println("3. Добавление студента.");
                System.out.println("Введите фамилию, имя студента:");
                String inputStudentName = scn.nextLine();

                System.out.println("Введите название курса:");
                String inputCourseName = scn.nextLine();

                String query = "INSERT INTO student (student_name, course_name) VALUES ('" + inputStudentName + "', '" + inputCourseName + "')";
                stmt.executeUpdate(query);

            }else if (input.equals("4")){
                System.out.println("4. Добавление предмета.");
                System.out.println("Введите название предмета:");
                String inputSubjectName = scn.nextLine();

                System.out.println("Введите длительность курса:");
                String inputSubjectDuration = scn.nextLine();

                String query = "INSERT INTO subject (subject_name, subject_duration) VALUES ('" + inputSubjectName + "', '" + inputSubjectDuration + "')";
                stmt.executeUpdate(query);

            }else if(input.equals("5")){
                System.out.println("5. Выход.");

            }else{
                System.out.println("Некорректный ввод.");
            }
        }
    }
}
