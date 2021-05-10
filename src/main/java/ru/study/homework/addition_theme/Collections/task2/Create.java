package ru.study.homework.addition_theme.Collections.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Create {

    Random rnd = new Random();

    Page page = null;
    Book book = null;
    String bookName = "";

    public Book createBook(int currentBook){

        bookName = "Book-" + currentBook;

        List<Page> tempPageList = new ArrayList<>();

        int pageAmount = rnd.nextInt(9) + 1; // количество страниц в книге

        for (int i = 0; i < pageAmount; i++) {
            String pageText = "Text on the page " + i;
            page = new Page(i, pageText);

            tempPageList.add(page);
        }

        return new Book (bookName, tempPageList);
    }
}