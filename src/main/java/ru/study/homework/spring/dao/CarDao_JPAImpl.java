package ru.study.homework.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.study.homework.spring.model.Car;
import ru.study.lesson.dao_pattern.util.HibernateUtil;
import ru.study.lesson.spring.ex2_dao.model.Book;

import java.util.List;

public class CarDao_JPAImpl implements DAO<Car>{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public void save (List<Car> listCar){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(Car cr : listCar){
            session.save(cr);
        }

        session.getTransaction().commit();
        session.close();

    }

    public List<Car> getAll(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Car> listCar = session.createQuery("from Car").getResultList();

        return listCar;
    }

    public Car getById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //Query<Car> query = session.createQuery("from Car where id := idParameter");
        Query<Car> query = session.createQuery("from Car where id =  "+id);
        //query.setParameter("idParameter", id);
        Car car = query.getSingleResult();
        return car;
    }

    @Override
    public void update(Car oldCar, Car newCar) {
        Session session = sessionFactory.openSession();
        Car car = getById(oldCar.getId());
        car.setPrice(newCar.getPrice());
        car.setAutoMaker(newCar.getAutoMaker());

        session.beginTransaction();
        session.merge(car);
        session.getTransaction().commit();



//        Car car = new Car(); //new | transactional
//        Car car1 = (Car)session.createQuery("from Car where id = 1").getSingleResult(); //managed | persist
//        session.close();
//        //car1 после закрытия сессии состояние detached
//        session = sessionFactory.openSession();
//        session.save(car1); //detached изменится на managed
//        session.remove(car1); //car1 перейдет в состояние new | transactional


    }

    @Override
    public void remove (int id) {
        Session session = sessionFactory.openSession();
        Car car = getById(id);
        session.beginTransaction();
        session.remove(car);
        session.getTransaction().commit();
    }

}
