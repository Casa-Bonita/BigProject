package ru.study.lesson.spring.ex2_dao.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import ru.study.lesson.spring.ex2_dao.InputBook;
import ru.study.lesson.spring.ex2_dao.dao.BookDao_FileImpl;
import ru.study.lesson.spring.ex2_dao.dao.BookDao_JPAImpl;
import ru.study.lesson.spring.ex2_dao.dao.DAO;
import ru.study.lesson.spring.ex2_dao.service.BookService;

public class Config {

    @Bean
    public DAO getDaoFile(){
        return new BookDao_FileImpl("src/main/java/ru/study/homework/DAO/fileBook.txt");
    }


    @Bean
    public DAO getDaoJPA(){
        return new BookDao_JPAImpl();
    }

    @Bean
    public InputBook getInputBook(){
        return new InputBook();
    }

    @Bean
    public BookService getBookService(){
//        return new BookService(getDaoJPA());
        return new BookService(getDaoFile());
    }



}
