package ru.study.lesson.spring.practice1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        Service service = applicationContext.getBean(Service.class);

        System.out.println(service.get());

    }
}
