package ru.study.homework.DAO.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.study.homework.DAO.model.Car;
import ru.study.lesson.dao_pattern.util.HibernateUtil;

import java.util.List;

public class CarDao_JPAImpl implements DAO<Car>{

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(List<Car> listCar) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(Car c : listCar){
            session.save(c);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Car> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Car> listCar = session.createQuery("from Car").getResultList();

        return listCar;
    }

    @Override
    public Car getById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query <Car> query = session.createQuery("from Car where id := idParameter");
        query.setParameter("idParameter", id);
        Car car = query.getSingleResult();

        return car;
    }

    @Override
    public void update(Car oldT, Car newT) {

    }

    @Override
    public void delete(Car car) {

    }
}
