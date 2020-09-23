package ru.study.homework.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.study.homework.spring.InputCar;
import ru.study.homework.spring.dao.CarDao_FileImpl;
import ru.study.homework.spring.dao.CarDao_JPAImpl;
import ru.study.homework.spring.dao.DAO;
import ru.study.homework.spring.service.CarService;


public class Config {



    @Bean
    public DAO getDAO_File(){
        return new CarDao_FileImpl("src/main/java/ru/study/homework/spring/fileCar.txt");
    }

    @Bean
    public DAO getDAO_JPA(){
        return new CarDao_JPAImpl();
    }

    @Bean
    public InputCar getInputCar(){
        return new InputCar();
    }

    @Bean
    public CarService getCarService(){
//        return new CarService(getDAO_JPA());
        return new CarService(getDAO_File());
    }

}
