package ru.study.lesson.spring.ex2_dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.study.lesson.spring.ex2_dao.dao.BookDao_FileImpl;
import ru.study.lesson.spring.ex2_dao.dao.BookDao_JPAImpl;
import ru.study.lesson.spring.ex2_dao.dao.DAO;
import ru.study.lesson.spring.ex2_dao.model.Book;

import java.util.List;

public class BookService {

    String pathFile = "src/main/java/ru/study/homework/DAO/fileBook.txt";

    //DAO<Book> dao = new BookDao_FileImpl(pathFile);
    //DAO<Book> dao = new BookDao_JPAImpl();

//    @Autowired
    DAO<Book> dao;


    public BookService(DAO<Book> dao) {
        this.dao = dao;
    }

    public void save (List<Book> listBook){
        dao.save(listBook);
    }

    public List<Book> getAll(){
        List<Book> listBook = dao.getAll();
        return listBook;
    }

    public Book getById(int id){
        return dao.getById(id);
    }

    public void update(Book oldBook, Book newBook){
        List<Book> listBook = dao.getAll();
        int index = 0;
        for (int i = 0; i < listBook.size(); i++) {
            if(listBook.get(i).getId() == oldBook.getId()){
                index = i;
            }
        }
        Book book = dao.getById(oldBook.getId());
        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());
        listBook.remove(index);
        listBook.add(book);
        dao.save(listBook);
    }

    public void delete(Book book){
        List<Book> listBook = dao.getAll();
        for (int i = 0; i < listBook.size(); i++) {
            if(listBook.get(i).getId() == book.getId()){
                listBook.remove(i);
                dao.save(listBook);
            }
        }
    }

}
