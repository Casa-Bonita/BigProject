package ru.study.lesson.dao_pattern.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.study.lesson.dao_pattern.model.Passport;
import ru.study.lesson.dao_pattern.model.User;
import ru.study.lesson.dao_pattern.util.HibernateUtil;

import java.util.List;

public class UserDaoHibernateImpl implements Dao<User> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, 1);

    }



    @Override
    public List<User> getAll() {
        return null;
    }



    @Override
    public void remove(User user) {

    }
}
