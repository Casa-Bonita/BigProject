package ru.study.homework.addition_theme.Collections.task2;

import java.util.Objects;

public class Page {
//    Создать класс Page с полями: номер страницы, текст на странице (текст делать коротким). Создать конструктор класса.
//    Две страницы считаются равными, если совпадает их номер.

    private int pageNumber;
    private String text;

    public Page() {
    }

    public Page(int pageNumber, String text) {
        this(pageNumber);
        this.text = text;
    }
    public Page(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "pageNumber = " + pageNumber + ", text = " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return pageNumber == page.pageNumber;
    }

}
