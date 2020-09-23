package ru.study.lesson.spring.ex2_dao.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.study.lesson.dao_pattern.util.HibernateUtil;
import ru.study.lesson.spring.ex2_dao.model.Book;

import java.util.List;

public class BookDao_JPAImpl implements DAO<Book> {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void save(List<Book> listBook) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        for(Book bk : listBook){
            session.save(bk);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Book> listBook = session.createQuery("from Book").getResultList();

        return listBook;
    }

    @Override
    public Book getById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query <Book> query = session.createQuery("from Book where id := idParameter");
        query.setParameter("idParameter", id);
        Book book = query.getSingleResult();

        return book;
    }

    @Override
    public void update(Book oldT, Book newT) {

    }

    @Override
    public void delete(Book book) {

    }
}
