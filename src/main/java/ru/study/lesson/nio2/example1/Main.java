package ru.study.lesson.nio2.example1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //считывание/запись в файл с Nio2
        Path path = Paths.get("src/ru/study/lesson/nio2/example1/test.txt");
       // List<String> list = Arrays.asList("one", "two", "three", "four");
        //первый способ записи

//        Files.write(path, list);
        //второй способ
//        BufferedWriter bw = Files.newBufferedWriter(path, StandardOpenOption.CREATE);
//        for(String val : list){
//            bw.write(val);
//            bw.newLine();
//        }
//        bw.close();


        //чтение:
        //первый способ
//        List<String> list = Files.readAllLines(path);
//        System.out.println(list);

        //второй способ
//        BufferedReader br = Files.newBufferedReader(path);
        //....




    }
}
