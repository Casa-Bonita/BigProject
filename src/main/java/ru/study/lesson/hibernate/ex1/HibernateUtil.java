package ru.study.lesson.hibernate.ex1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    public static SessionFactory createSessionFactory(){

        Configuration configuration = new Configuration().configure();
        return configuration.buildSessionFactory();

    }
}
