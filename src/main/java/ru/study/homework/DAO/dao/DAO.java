package ru.study.homework.DAO.dao;

import java.util.List;

public interface DAO<T> {

    // create
    void save(List<T> t);
    default void save(T t){}

    // read by id
    T getById(int id);

    // read
    List<T> getAll();

    // update
    void update(T oldT, T newT);

    // delete
    void delete(T t);
}
