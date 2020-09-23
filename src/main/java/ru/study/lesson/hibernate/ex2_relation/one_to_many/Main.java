package ru.study.lesson.hibernate.ex2_relation.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.study.lesson.hibernate.ex2_relation.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.createSessionFactory();

//        Library library = new Library();
//        library.setAddress("Address1");
//        Book book = new Book("book1");
//        Book book1 = new Book("book2");
//        Book book2 = new Book("book3");
//
//      //связываем обязательно библиотеку  с книгами
//        library.getBookList().add(book);
//        library.getBookList().add(book1);
//        library.getBookList().add(book2);
//    //связываем обязательно книги с библиотекой
//        book.setLibrary(library);
//        book1.setLibrary(library);
//        book2.setLibrary(library);


//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(library);
//        session.save(book);
//        session.save(book1);
//        session.save(book2);
//        session.getTransaction().commit();


        //Загрузим библиотеку из базы
        Session session = sessionFactory.openSession();
        Library library = (Library)session.createQuery("from Library").getSingleResult();
        System.out.println("RESULT:");
        System.out.println(library.getAddress());
        System.out.println(library.getBookList());

        //Добавим еще одну книгу и проверим некорректное связывание
//        Book book4 = new Book("Book4");
//        library.getBookList().add(book4);
//
//        session.beginTransaction();
//        session.save(library);
//        session.save(book4);
//        session.getTransaction().commit();
        //так как мы не связали книгу с библиотекой (book4.setLibrary(library)), то при загружке библиотеки этой книги нет и также
        //у книги нет внешнего ключа в базе на библиотеку


        //Проверка каскада
        session.beginTransaction();
        session.remove(library);
        session.getTransaction().commit();



    }
}
