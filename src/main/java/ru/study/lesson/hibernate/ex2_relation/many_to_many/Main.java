package ru.study.lesson.hibernate.ex2_relation.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.study.lesson.hibernate.ex2_relation.HibernateUtil;

public class Main {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan");
        Student st2 = new Student("Petr");

        Prepod prepod1 = new Prepod("Prepod1");
        Prepod prepod2 = new Prepod("Prepod2");

        prepod1.getStudentList().add(st1);
        st1.getPrepodList().add(prepod1);

        prepod1.getStudentList().add(st2);
        st2.getPrepodList().add(prepod1);

        prepod2.getStudentList().add(st2);
        st2.getPrepodList().add(prepod2);

        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//        session.save(st1);
//        session.save(st2);
//        session.save(prepod1);
//        session.save(prepod2);
//        session.getTransaction().commit();


        Session session = sessionFactory.openSession();
        Student student = (Student)session.createQuery("from Student where id = 2").getSingleResult();
        System.out.println(student);
        Prepod prepod = (Prepod) session.createQuery("from Prepod where id = 1").getSingleResult();
        System.out.println(prepod);
        System.out.println(prepod.getStudentList());
    }
}
