package ru.study.lesson.dao_pattern.dao;

import java.util.List;

public interface Dao<T> {

    void save(T t);
    T getById(int id);
    List<T> getAll();
    void remove(T t);

}
