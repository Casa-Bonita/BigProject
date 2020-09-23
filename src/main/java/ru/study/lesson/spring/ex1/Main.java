package ru.study.lesson.spring.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = context.getBean(User.class);
        user.setName("Ivan");
        System.out.println(user);
        User user2 = context.getBean(User.class);
        System.out.println(user2);


        Tovar tovar = context.getBean(Tovar.class);
        Tovar tovar2 = (Tovar)context.getBean("getTovar");

        System.out.println(tovar);
        System.out.println(tovar2);


    }
}
