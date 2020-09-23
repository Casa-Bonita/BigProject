package ru.study.lesson.date.practice1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //ОпределитЬ, входит ли дата в промежуток дат

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try{
            Date dateStart = sdf.parse("1.1.1980");
            Date dateEnd = sdf.parse("10.10.1990");

            Date dateTest = sdf.parse("05.05.1985");

            if(dateStart.compareTo(dateTest) <= 0 && dateEnd.compareTo(dateTest) >= 0){
                System.out.println("Дата в указанном диапазоне");
            }else{
                System.out.println("Дата вне указанного диапазона");
            }
        }
        catch(ParseException e){
            e.printStackTrace();
        }




    }
}
