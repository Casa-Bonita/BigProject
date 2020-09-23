package ru.study.lesson.io.example2;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //чем отличаются байтовые потоки от символьных
        //символьные потоки считывают за один раз 1 символ, а байтовые - 1 байт, причем в UTF русские символы занимают 2 байта

        //байтовое считывание с консоли
        //System.out.println("test");

        //побайтовое считывание с консоли
//        System.out.println("Введите символ");
//        int code = System.in.read();
//        System.out.println((char)code);

        //считывание нескольких символов
//        byte[] arr = new byte[10];
//        System.out.println("Введите не более 10 символов");
//        System.in.read(arr);
//        String str = new String(arr);
//        System.out.println("Вы ввели: "+str);


        //Вывод ошибок красный цветом
//        System.err.println("Ошибка какая-то");


        //Файлы
//        String pathFile = "src/ru/study/lesson/io/example2/test.txt";
//        FileInputStream fis = new FileInputStream(pathFile);
//        byte[] arr = fis.readAllBytes();
//        String str = new String(arr);
//        System.out.println(str);

//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathFile));
//        int code = bis.read();
//        while(code!=-1){
//            System.out.print((char)code);
//            code = bis.read();
//        }


        //Сериализация
//        String pathFile = "src/ru/study/lesson/io/example2/test.txt";
        //Для сериализации класс Tovar Должен реализоваывать интерфейс Serialisable
//        List<Tovar> list = Arrays.asList(new Tovar("Tovar1", 100), new Tovar("Tovar2", 200));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathFile));
//        oos.writeObject(list);
//        oos.close();

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathFile));
//        List<Tovar> list = (List<Tovar>)ois.readObject();
//        ois.close();
//        System.out.println(list);

    }
}
