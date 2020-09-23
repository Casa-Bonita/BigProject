package ru.study.lesson.spring.ex2_dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.study.lesson.spring.ex2_dao.model.Book;
import ru.study.lesson.spring.ex2_dao.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputBook {

    @Autowired
    BookService bookService;

    public void inputBook(){
        Scanner scn = new Scanner(System.in);
        String input = "";

        Book book = new Book();
        //BookService bookService = new BookService();

        List<Book> listBook = new ArrayList<>();

        while(!input.equals("5")){
            System.out.println("1. Create.");
            System.out.println("2. Read.");
            System.out.println("3. Update.");
            System.out.println("4. Delete.");
            System.out.println("5. Exit.");
            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Create.");
                Book book1 = new Book(1, "Voina I Mir", "L. Tolstoy");
                Book book2 = new Book(2, "Prestuplenie I Nakazanie", "F. Dostoevskiy");
                Book book3 = new Book(3, "Oblomov", "I. Goncharov");
                Book book4 = new Book(4, "Nos", "N. Gogol");
                listBook.add(book1);
                listBook.add(book2);
                listBook.add(book3);
                listBook.add(book4);

                bookService.save(listBook);

            }
            else if(input.equals("2")){
                System.out.println("2. Read.");

                System.out.println("Вывести все данные? y/n");
                String inputData = scn.nextLine();

                if(inputData.equals("y")){
                    listBook = bookService.getAll();
                    listBook.stream()
                            .forEach(x -> System.out.println(x.getId() + "   " + x.getName() + "   " + x.getAuthor()));
                }

                else if(inputData.equals("n")){
                    System.out.println("Введите id книги, которая будет считана");
                    String temp = scn.nextLine();
                    int inputId = Integer.parseInt(temp);
                    book = bookService.getById(inputId);
                    System.out.println(book.getId() + "   " + book.getName() + "   " + book.getAuthor());
                }

            }
            else if(input.equals("3")){
                System.out.println("3. Update.");
                System.out.println("Введите id книги, которая будет заменена:");
                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);

                System.out.println("Будет заменена кнга:");
                Book oldBook = bookService.getById(inputId);
                System.out.println(oldBook.getId() + "   " + oldBook.getName() + "   " + oldBook.getAuthor());

                System.out.println("Введите данные новой книги");
                System.out.println("Введите название книги:");
                String newName = scn.nextLine();
                System.out.println("Введите автора:");
                String newAuthor = scn.nextLine();
                Book newBook = new Book(inputId, newName, newAuthor);

                bookService.update(oldBook, newBook);
                listBook = bookService.getAll();
                listBook.stream()
                        .forEach(x -> System.out.println(x.getId() + "   " + x.getName() + "   " + x.getAuthor()));

            }
            else if(input.equals("4")){
                System.out.println("4. Delete.");
                System.out.println("Введите id книги, которая будет удалена");
                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);
                Book deletedBook = bookService.getById(inputId);
                bookService.delete(deletedBook);

            }
            else if(input.equals("5")){
                System.out.println("5. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");
            }
        }

    }
}
