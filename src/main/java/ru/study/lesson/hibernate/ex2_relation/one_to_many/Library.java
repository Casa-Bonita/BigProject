package ru.study.lesson.hibernate.ex2_relation.one_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //mappedBy указывает, что библиотека будет
    //связываться с книгами по полю library в классе Book
    //fetch - загрузка связанных сущностей
    //cascade - влияние изменения главной таблицы на зависимые (удаление библиотеки приведет к удаленю всех ее книг)
    private List<Book> bookList = new ArrayList<>();

    public Library(String address) {
        this.address = address;
    }

    public Library() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
