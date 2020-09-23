package ru.study.lesson.spring.ex1;

import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    //@Scope("prototype")
    public User getUser(){
        return new User();
    }

    @Bean
    public Tovar getTovar(){
        return new Tovar();
    }
}
