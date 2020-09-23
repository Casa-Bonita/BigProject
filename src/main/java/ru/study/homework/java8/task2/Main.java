package ru.study.homework.java8.task2;

import ru.study.lesson.java8.stream.ex4.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

//    2. Создать класс Book с полями название книги и цена.
//    В main создать массив или список книг и заполнить его значениями.
//    С помощью одного stream найти самую дорогую книгу с помощью метода max и сохранить ее в переменную.
//    После нахождения вывести информацию о ней на консоль из переменной.
        List<Book> listBook = new ArrayList<>();

        Path path = Paths.get("src/main/java/ru/study/homework/java8/task2/fileTask2.txt");
        List<String> listInput = new ArrayList<>(Files.readAllLines(path)); // listInput - список со всеми входными данными

        for (int i = 0; i < listInput.size(); i++) {
            String [] line = listInput.get(i).split(";");
            listBook.add(new Book (line[0], Integer.parseInt(line[1])));
        }

        // просмотр того, что считано из файла

        System.out.println("\n" + "Название книги:");
        listBook.stream()
                .map(Book::getName)
                .forEach(System.out::println);

        System.out.println("\n" + "Цена книги:");
        listBook.stream()
                .map(Book::getPrice)
                .forEach(System.out::println);


        // поиск максимальной цены

        OptionalInt maxTemp = listBook.stream()
                .mapToInt(Book::getPrice)
                .max();
        int max = maxTemp.getAsInt();

        System.out.println("\n" + "Стоимость самой дорогой книги = " + max);


        // книга, которая стоит максимальную цену
        System.out.print("\n" + "Название самой дорогой книги = ");
        listBook.stream()
                .filter(book -> book.getPrice() == max)
                .map(Book::getName)
                .forEach(System.out::println);


    }
}