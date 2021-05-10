package ru.study.homework.addition_theme.Collections.task2;

import ru.study.homework.addition_theme.Collections.task2.Create;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//    2. Возьмем задачу из предыдущих тем и применим к ним новые знания: заменим массивы на списки, методы print на toString, а также переопределим equals.
//    В задаче описаны минимальные требования. Можно дописывать свои методы к классам.
//    Создать класс Page с полями: номер страницы, текст на странице (текст делать коротким). Создать конструктор класса.
//    Две страницы считаются равными, если совпадает их номер.
//    Создать класс Book с полями: название книги и список типа Page. Две книги считаются равными, если совпадает их название.
//
//    В классе Book создать методы:
//    public void addPage (Page page) - добавляет страницу в книгу;
//    public void removePage (int index) - удаляет страницу (не просто приравнивает к null, а удаляет);
//    public String getPageText (int number) - возвращает текст со страницы под номером number. Если страницы с таким номером нет в книге, возвращает пустую строку "";
//    public int getPageCount () - возвращает количество добавленных страниц в книге.
//
//    В Main создать список типа Book и консольное меню:
//
//    1. Добавить книгу в список;
//    2. Добавить страницу в книгу (по названию книги);
//    3. Удалить страницу из книги (по названию книги и номеру страницы);
//    4. Вывести всю информацию о книге (выводится название книги и вся информация со страниц);
//    5. Вывести текст со страницы под номером из книги (пользователь вводит название книги и номер страницы);
//    6. Выход.

        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);

        Create create = new Create();
//        Book book = new Book();
//        Page page = new Page();

        List<Book> bookList = new ArrayList<>();
       // List<Page> pageList = new ArrayList<>();

        String input = "";

        while(!input.equals("8")){
            System.out.println("1. Создать список с книгами.");
            System.out.println("2. Вывести на экран список с книгами.");
            System.out.println("3. Добавить книгу в список.");
            System.out.println("4. Добавить страницу в книгу (по названию книги).");
            System.out.println("5. Удалить страницу из книги (по названию книги и номеру страницы).");
            System.out.println("6. Вывести всю информацию о книге (выводится название книги и вся информация со страниц).");
            System.out.println("7. Вывести текст со страницы под номером из книги (пользователь вводит название книги и номер страницы).");
            System.out.println("8. Выход.");

            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Создать список с книгами.");

                int bookAmount = rnd.nextInt(5) + 2; // количество объектов Book

                for (int i = 0; i < bookAmount; i++) {
                    bookList.add(create.createBook(i));
                }

                System.out.println("1. Список с книгами создан." + "\n");

            }
            else if(input.equals("2")){
                System.out.println("2. Вывести на экран список с книгами.");

                for (int i = 0; i < bookList.size(); i++) {
                    System.out.println(bookList.get(i));
                }

            }
            else if(input.equals("3")){
                System.out.println("3. Добавить книгу в список.");

                System.out.println("Для добавления новой книги введите - Y, для отказа от добавления - любой символ.");
                String temp = scn.nextLine();
                if(temp.equalsIgnoreCase("y")){
                    bookList.add(create.createBook(bookList.size()));
                    System.out.println("Книга добавлена.");
                }
                else{
                    System.out.println("Книга не добавлена.");
                }

            }
            else if(input.equals("4")){
                //    public void addPage (Page page) - добавляет страницу в книгу;
                System.out.println("4. Добавить страницу в книгу (по названию книги).");

                System.out.println("\n" + "Введите название книги.");
                String bookName = scn.nextLine();
                int index = bookList.indexOf(new Book(bookName));
                if(index==-1){
                    System.out.println("Книги не существует");
                }else{
                    System.out.println("Enter page number");
                    int number = scn.nextInt();
                    scn.nextLine(); //сбрасываем сканнер
                    System.out.println("Enter page text");
                    String text = scn.nextLine();

                    bookList.get(index).addPage(new Page(number, text));
                }



            }
            else if(input.equals("5")){
                //    public void removePage (int index) - удаляет страницу (не просто приравнивает к null, а удаляет);
                System.out.println("5. Удалить страницу из книги (по названию книги и номеру страницы).");

                System.out.println("\n" + "Введите название книги.");
                String bookName = scn.nextLine();
                System.out.println("\n" + "Введите номер страницы.");
                String temp = scn.nextLine();
                int deletePageNumber = Integer.parseInt(temp);
                int index = bookList.indexOf(new Book(bookName));
                if(index!=-1){
                    Book book = bookList.get(index);
                    int deletePageIndex = book.getPageList().indexOf(new Page(deletePageNumber));
                    if(deletePageIndex!=-1){
                        book.getPageList().remove(deletePageIndex);
                    }
                }


            }
            else if(input.equals("6")){
                //    public int getPageCount () - возвращает количество добавленных страниц в книге.
                System.out.println("6. Вывести всю информацию о книге (выводится название книги и вся информация со страниц).");

                System.out.println("\n" + "Введите название книги.");
                String fromBook = scn.nextLine();

                int index = bookList.indexOf(new Book(fromBook));
                if(index!=-1){
                    System.out.println(bookList.get(index));
                }else{
                    System.out.println("Книга не найдена");
                }
            }
            else if(input.equals("7")){
                //    public String getPageText (int number) - возвращает текст со страницы под номером number.
                //    Если страницы с таким номером нет в книге, возвращает пустую строку "";
                System.out.println("7. Вывести текст со страницы под номером из книги (пользователь вводит название книги и номер страницы).");

                System.out.println("\n" + "Введите название книги.");
                String fromBook = scn.nextLine();
                System.out.println("\n" + "Введите номер страницы.");
                String temp = scn.nextLine();
                int viewPageNumber = Integer.parseInt(temp);

                int index = bookList.indexOf(new Book(fromBook));
                if(index!=-1){
                    Book book = bookList.get(index);
                    int pageIndex = book.getPageList().indexOf(new Page(viewPageNumber));
                    if(pageIndex!=-1){
                        System.out.println(book.getPageList().get(pageIndex).getText());
                    }
                }

            }

            else if(input.equals("8")){
                System.out.println("8. Выход.");

            }
            else{
                System.out.println("Некорректный ввод.");

            }

        }



    }
}

