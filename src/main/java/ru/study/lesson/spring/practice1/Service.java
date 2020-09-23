package ru.study.lesson.spring.practice1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;
import java.util.List;

public class Service {
    List<String> store;

    public Service(List <String> store){
        this.store = store;
    }

    public String get(){
        return store.get(0);
    }
}
