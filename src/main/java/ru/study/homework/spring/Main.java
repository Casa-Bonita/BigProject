package ru.study.homework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.study.homework.spring.config.Config;
import ru.study.homework.spring.service.CarService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        InputCar inputCar = context.getBean(InputCar.class);
        inputCar.inputCar();



    }
}
