package ru.study.lesson.dao_pattern.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.study.lesson.dao_pattern.model.Passport;
import ru.study.lesson.dao_pattern.util.HibernateUtil;


import java.util.List;

public class PassportDaoHibernateImpl implements Dao<Passport> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(Passport passport) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(passport);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Passport getById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Passport.class, 1);

    }


    @Override
    public List<Passport> getAll() {
        return null;
    }



    @Override
    public void remove(Passport passport) {

    }
}
