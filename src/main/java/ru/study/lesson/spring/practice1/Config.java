package ru.study.lesson.spring.practice1;

import org.springframework.context.annotation.Bean;

public class Config {

    @Bean
    public StoreArrayList getStoreList (){
        return new StoreArrayList();
    }

    @Bean
    public StoreLinkedList getStoreLinkedList(){
        return new StoreLinkedList();
    }

    @Bean
    public Service getService(){
        return new Service(getStoreLinkedList());
        //return new Service(getStoreList());
    }
}
