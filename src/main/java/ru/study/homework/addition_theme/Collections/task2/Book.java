package ru.study.homework.addition_theme.Collections.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Book {
//    Создать класс Book с полями: название книги и список типа Page. Две книги считаются равными, если совпадает их название.
//    В классе Book создать методы:
//    public void addPage (Page page) - добавляет страницу в книгу;
//    public void removePage (int index) - удаляет страницу (не просто приравнивает к null, а удаляет);
//    public String getPageText (int number) - возвращает текст со страницы под номером number. Если страницы с таким номером нет в книге, возвращает пустую строку "";
//    public int getPageCount () - возвращает количество добавленных страниц в книге.

    private String bookName;
    private List<Page> pageList;

    public Book() {
        pageList = new ArrayList<>();
    }

    public Book(String bookName, List<Page> pageList) {
        this(bookName);
        this.pageList = pageList;
    }
    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book name: ").append(bookName).append("\n");
        sb.append("Page list:\n");
        for (int i = 0; i < pageList.size(); i++) {
            sb.append(pageList.get(i)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName);
    }


    //    public void addPage (Page page) - добавляет страницу в книгу;
    public void addPage (Page page){
        pageList.add(page);
    }

    //    удаляет страницу (не просто приравнивает к null, а удаляет);
    public void removePage (int index){
        pageList.remove(index);
    }

    //    возвращает текст со страницы под номером number. Если страницы с таким номером нет в книге, возвращает пустую строку "";
    public String getPageText (int number){

        int index = pageList.indexOf(new Page(number));
        if(index==-1) {
            return "";
        }
        return pageList.get(index).getText();
    }

    //    возвращает количество добавленных страниц в книге.
    public int getPageCount (){
        return pageList.size();
    }
}