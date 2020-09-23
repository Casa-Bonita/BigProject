package ru.study.homework.multithreading.task1;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static javax.swing.UIManager.get;

public class Main{

    public static void main(String[] args) throws IOException, ParseException {

//    1. Создать интерфейсы:
//    public interface MyReader{
//        void read(String filepath);
//    }
//
//    public interface MyWriter{
//        void write(String filepath);
//    }
//
//    filepath - путь к файлу
//
//    Создать класс MyReaderWriterService с двумя статическими методами:
//
//    public static void startRead(MyReader reader, String filepath){
//        reader.read(filepath);
//    }
//
//    public static void startWrite(MyWriter writer, String filepath){
//        writer.write(filepath);
//    }
//
//    В main создать консольное меню:
//    1. Записать в файл строку через PrintWriter (при выборе с консоли считывается строка и записывается в файл)
//    2. Записать в файл строку через BufferedWriter (при выборе с консоли считывается строка и записывается в файл)
//    3. Считать из файла строку через FileReader (при выборе из файла считывается строка и выводится на консоль)
//    4. Считать из файла строку через BufferedReader (при выборе из файла считывается строка и выводится на консоль)
//    5. Выход
//
//    Можно записывать/считывать не только одну строку, можно сделать и для неограниченного количества строк.(При этом, возможно, следует создать для каждого пункта
//    отдельный файл, так как возможна ситуация, когда будет открыто 4 потока к одному файлу. Либо закрывать поток после каждой операции,
//    но тогда данный в файле будут перезаписываться)
//
//    Чтение/Запись при выборе каждого пункта должна происходить через вызов методов startRead/startWrite соответственно. Для этого в их параметры нужно
//    передавать объект, реализующий чтение/запись соответствующим способом (в соответствии с пунктами меню).
//    Для того, чтобы вам не пришлось создавать четыре отдельных класса, которые будут реализовывать данные интерфейсы с различными методами
//    считывания/записи нужно создавать объект через анонимные классы, используя лямбда выражение (лямбда выражения нужны для сокращения кода
//    при создании анонимного класса. Технически, они не обязательны).

        Scanner scn = new Scanner(System.in);
        Charset win1251 = Charset.forName("Windows-1251");
        String input = "";

        System.out.println("Выберите пункт меню:");
        while(!input.equals("5")){
            System.out.println("1. Записать в файл строку через PrintWriter.");
            System.out.println("2. Записать в файл строку через BufferedWriter.");
            System.out.println("3. Считать из файла строку через FileReader.");
            System.out.println("4. Считать из файла строку через BufferedReader.");
            System.out.println("5. Выход.");
            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("PrintWriter");

//                System.out.println("Введите строку для записи в файл:");
//                String str = scn.nextLine();
                String str = "Common baby light my fire";
                System.out.println("Будет произведена запись строки = " + "\"" + str + "\"");

                String pathFile1 = "src/ru/study/homework/multithreading/task1/data1.txt";
                MyWriter myWriter1 = (path)->{
                    PrintWriter pw = null;
                    try {
                        pw = new PrintWriter(path);
                        for (int i = 1; i < 21; i++) {
                            pw.println(str + " " + i);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }finally {
                        pw.close();
                    }
                };

                Runnable runnable = ()->{
                    MyReaderWriterService.startWrite(myWriter1, pathFile1);
                };
                new Thread(runnable).start();

                System.out.println("Данные записаны");

            }else if(input.equals("2")){
                System.out.println("BufferedWriter");

//                System.out.println("Введите строку для записи в файл:");
//                String str = scn.nextLine();
                String str = "All you need is love";
                System.out.println("Будет произведена запись строки = " + "\"" + str + "\"");

                String pathFile2 = "src/ru/study/homework/multithreading/task1/data2.txt";

                MyWriter myWriter2 = (path)->{

                    BufferedWriter bw = null;
                    try{
                        FileOutputStream fos = new FileOutputStream(pathFile2);
                        OutputStreamWriter osw = new OutputStreamWriter(fos, win1251);
                        bw = new BufferedWriter(osw);

                        for (int i = 1; i < 21; i++) {
                            bw.write(str + " " + i);
                            bw.newLine();
                        }

                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        try {
                            bw.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                MyReaderWriterService.startWrite(myWriter2, pathFile2);

                System.out.println("Данные записаны");

            }else if(input.equals("3")){
                System.out.println("FileReader");

                String pathFile3 = "src/ru/study/homework/multithreading/task1/data3.txt";

                MyReader myReader1 = (path) ->{

                    FileReader fr = null;

                    try{
                        fr = new FileReader(pathFile3);
                        int symbolInt = fr.read();
                        while(symbolInt!=-1){
                            char symbolChar = (char) symbolInt;
                            System.out.print(symbolChar);
                            symbolInt = fr.read();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        try{
                            fr.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                MyReaderWriterService.startRead(myReader1, pathFile3);

                System.out.println("\n");

            }else if(input.equals("4")){
                System.out.println("BufferedReader");

                String pathFile4 = "src/ru/study/homework/multithreading/task1/data4.txt";

                MyReader myReader2 = (path) ->{
                    FileInputStream fis = null;
                    BufferedReader br = null;
                    try{
                        fis = new FileInputStream(pathFile4);
                        InputStreamReader isr = new InputStreamReader(fis, win1251);
                        br = new BufferedReader (isr);

                        int symbolInt = br.read();
                        while(symbolInt != -1){
                            char symbolChar = (char) symbolInt;
                            System.out.print(symbolChar);
                            symbolInt = br.read();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }finally {
                        try{
                            br.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                MyReaderWriterService.startRead(myReader2, pathFile4);

                System.out.println("\n");

            }else if(input.equals("5")){
                System.out.println("Программа завершила свою работу.");

            }else{
                System.out.println("Некорректный ввод.");
            }
        }
    }
}