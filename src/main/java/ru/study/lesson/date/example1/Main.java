package ru.study.lesson.date.example1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        //человеческая дата  - java.util.date, имеет вид 20.01.1990
        //дата для БД - java.sql.date, имеет вид 1990-01-20

        //Конвертация из строки в java.util.Date
//        String str1 = "20.04.2019";
//        String str2 = "21.04.2019";
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        Date date1 = sdf.parse(str1);
//        Date date2 = sdf.parse(str2);
//        System.out.println(date1.compareTo(date2));
//        System.out.println(date1);
//        System.out.println(date2);
//
//        //сравнение дат
//
//
//        //форматирование даты
//        sdf = new SimpleDateFormat("dd.MM.yyyy : HH:mm:ss:S");
//        String dateFormat1 = sdf.format(date1);
//        String dateFormat2 = sdf.format(date2);
//        System.out.println(dateFormat1);
//        System.out.println(dateFormat2);
//
//        //получить текущее время
//        Date currentDate = Calendar.getInstance().getTime();
//        sdf = new SimpleDateFormat("dd.MM.yyyy : HH:mm:ss");
//        String currentDateFormat = sdf.format(currentDate);
//        System.out.println(currentDateFormat);




    }
}
