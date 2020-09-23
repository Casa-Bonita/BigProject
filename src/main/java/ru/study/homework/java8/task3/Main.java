package ru.study.homework.java8.task3;

import ru.study.lesson.java8.stream.ex5.Product;
import ru.study.lesson.java8.stream.ex5.Shop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

//    3. Создать класс Book с полями цена, название, автор.
//    Создать класс Library со списком книг.
//    Заполнить список значениями.
//
//    В main создать консольное меню:
//    1. Вывести все книги из библиотеки (выводится полная информация);
//    2. Вывести все книги одного автора (пользователь вводит автора с консоли);
//    3. Найти самую дорогую книгу и вывести информацию о ней на консоль;
//    4. Вывести книги, чья цена не дороже 500;
//    5. Выход.
//
//    Все пункты меню должны выполняться с использованием stream.

        List<Library> libraries = new ArrayList<>();

        Path path = Paths.get("src/main/java/ru/study/homework/java8/task3/fileTask3.txt");
        List<String> listInput = new ArrayList<>(Files.readAllLines(path)); // listInput - список со всеми входными данными

        List<Book> listBook1 = new ArrayList<>(); // список книг 1-й библиотеки
        List<Book> listBook2 = new ArrayList<>(); // список книг 2-й библиотеки

        for (int i = 0; i < listInput.size(); i++) { // 1-я половина книг из входных данных поступает в 1-ю библиотеку, 2-я, соответственно, во 2-ю
            String [] line = listInput.get(i).split(";");
            if(i < listInput.size() / 2){
                listBook1.add(new Book(Integer.parseInt(line[0]), line[1], line[2]));
            }else{
                listBook2.add(new Book(Integer.parseInt(line[0]), line[1], line[2]));
            }
        }

        Library library1 = new Library(listBook1);
        Library library2 = new Library(listBook2);

        libraries.add(library1);
        libraries.add(library2);

        Scanner scn = new Scanner (System.in);
        String input = "";

        String [] menu = new String[] {
            "1. Вывести все книги из библиотеки (выводится полная информация).",
            "2. Вывести все книги одного автора (пользователь вводит автора с консоли).",
            "3. Найти самую дорогую книгу и вывести информацию о ней на консоль.",
            "4. Вывести книги, чья цена не дороже 500.",
            "5. Выход."
        };

        while(!input.equals("5")){
            Arrays.stream(menu)
                    .forEach(System.out::println);

            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Вывести все книги из библиотеки (выводится полная информация).");

// 1-й вариант вывода
                System.out.println("\n" + "Полная информация о книгах:");
                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .forEach(book -> System.out.printf("%-20s %-20s %-20s %n",book.getAuthor(), book.getName(), book.getPrice()));

// 2-й вариант вывода

                System.out.println("\n" + "Авторы произведений:");
                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .map(Book::getAuthor)
                        .forEach(System.out::println);

                System.out.println("\n" + "Названия книг:");
                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .map(Book::getName)
                        .forEach(System.out::println);

                System.out.println("\n" + "Стоимость книг:");
                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .map(Book::getPrice)
                        .forEach(System.out::println);

                System.out.println();

            }
            else if(input.equals("2")){
                System.out.println("2. Вывести все книги одного автора (пользователь вводит автора с консоли).");
                System.out.println("Введите фамилию автора");
                String inputAuthor = scn.nextLine();

                System.out.println("Произведения автора " + inputAuthor);
                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .filter(book -> book.getAuthor().equals(inputAuthor))
                        .forEach(book -> System.out.printf("%-20s %-20s %-20s %n",book.getAuthor(), book.getName(), book.getPrice()));

                System.out.println();

            }
            else if(input.equals("3")){
                System.out.println("3. Найти самую дорогую книгу и вывести информацию о ней на консоль.");

                OptionalInt maxTemp = libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .mapToInt(Book::getPrice)
                        .max();

                int max = maxTemp.getAsInt();

                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .filter(book -> book.getPrice() == max)
                        .forEach(book -> System.out.printf("%-20s %-20s %-20s %n",book.getAuthor(), book.getName(), book.getPrice()));

                System.out.println();

            }
            else if(input.equals("4")){
                System.out.println("4. Вывести книги, чья цена не дороже 500.");

                libraries.stream()
                        .map(Library::getBooks)
                        .flatMap(list -> list.stream())
                        .filter(book -> book.getPrice() < 500)
                        .forEach(book -> System.out.printf("%-20s %-20s %-20s %n",book.getAuthor(), book.getName(), book.getPrice()));

                System.out.println();

            }
            else if(input.equals("5")){
                System.out.println("Программа завершила работу.");

            }
            else{
                System.out.println("Некорректный ввод.");
            }
        }
    }
}
