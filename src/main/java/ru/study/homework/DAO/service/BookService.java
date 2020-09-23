package ru.study.homework.DAO.service;

import ru.study.homework.DAO.dao.BookDao_FileImpl;
import ru.study.homework.DAO.dao.DAO;
import ru.study.homework.DAO.model.Book;

import java.util.List;

public class BookService {

    String pathFile = "src/main/java/ru/study/homework/DAO/fileBook.txt";

    DAO<Book> dao = new BookDao_FileImpl(pathFile);

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
            }
        }
        dao.save(listBook);
    }

}
