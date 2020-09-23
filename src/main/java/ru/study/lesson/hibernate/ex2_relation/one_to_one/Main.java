package ru.study.lesson.hibernate.ex2_relation.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.study.lesson.hibernate.ex2_relation.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        Car car1 = new Car("Logan");
        Car car2 = new Car("Granta");

        GosNumber gosNumber1 = new GosNumber("A001AA197");
        GosNumber gosNumber2 = new GosNumber("B002BB197");

        car1.setGosNumber(gosNumber1);
        car2.setGosNumber(gosNumber2);

        gosNumber1.setCar(car1);
        gosNumber2.setCar(car2);

        session.beginTransaction();
        session.save(car1);
        session.save(car2);
        session.save(gosNumber1);
        session.save(gosNumber2);
        session.getTransaction().commit();
    }
}
