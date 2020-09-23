package ru.study.lesson.hibernate.ex1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        //ORM - object relation model
        //Class.forName("org.mariadb.jdbc.Driver")
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Tovar> query= session.createQuery("from Tovar where tovar_name = :tovar_nameParam");
        query.setParameter("tovar_nameParam", "Apple");
        Tovar tovarList = query.getSingleResult();
        System.out.println(tovarList);


//        Query<Sklad> query1 = session.createQuery("from Sklad");
//        List<Sklad> skladList = query1.getResultList();
//        for(Sklad sklad : skladList){
//            System.out.println(sklad);
//        }

        //добавление объекта в базу
//        session.beginTransaction();
//        try {
//            Sklad newSklad = new Sklad ("Vladivostok");
//            session.save(newSklad);
//            session.getTransaction().commit();
//        }catch(Exception ex){
//            session.getTransaction().rollback();
//        }


        //изменение
        //сначала достаем из базы
//        Query<Sklad> query2= session.createQuery("from Sklad where sklad_address = :sklad_addressParam");
//        query2.setParameter("sklad_addressParam", "Vladivostok");
//        Sklad sklad2 = query2.getSingleResult();
//        //меняем имя
//        sklad2.setSklad_address("Vladimir");
//        //обновляем
//        session.beginTransaction();
//        session.save(sklad2);
//        session.getTransaction().commit();


        //Удаление
        //получаем
        Query<Sklad> query2= session.createQuery("from Sklad where sklad_address = :sklad_addressParam");
        query2.setParameter("sklad_addressParam", "Vladimir");
        Sklad sklad2 = query2.getSingleResult();
        session.beginTransaction();
        session.remove(sklad2);
        session.getTransaction().commit();








    }
}
