package ru.study.lesson.hibernate.ex2_relation.one_to_many;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String book_name;

    @ManyToOne(fetch = FetchType.EAGER) //fetch - тип загружки связанных объектов
    //Eager означает, что при загрузке книги из базы автоматом будет загружена библиотека
    //Laze означает, что призагрузке  книги из базы автоматом не будет загружена библиотека,
    //а только при непосредственном обращении к ней
    @JoinColumn(name = "library_id") //создаем внешний ключ library_id в таблице Book
    private Library library;

    public Book() {
    }

    public Book(String book_name) {
        this.book_name = book_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
