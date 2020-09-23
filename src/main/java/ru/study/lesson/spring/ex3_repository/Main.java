package ru.study.lesson.spring.ex3_repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.study.lesson.spring.ex3_repository.entity.Passport;
import ru.study.lesson.spring.ex3_repository.service.PassportService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        PassportService service = context.getBean(PassportService.class);
        //service.save(new Passport(1234, 123456, "Ivan"));
        service.getAll().forEach(System.out::println);



    }
}
