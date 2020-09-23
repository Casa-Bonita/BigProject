package ru.study.lesson.dao_pattern.service;

import ru.study.lesson.dao_pattern.dao.Dao;
import ru.study.lesson.dao_pattern.dao.UserDaoArrayListImpl;
import ru.study.lesson.dao_pattern.dao.UserDaoHibernateImpl;
import ru.study.lesson.dao_pattern.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class UserService {
    Dao<User> dao = new UserDaoArrayListImpl();
    //Dao<User> dao = new UserDaoHibernateImpl();


    public void save(User user){
        dao.save(user);
    }

    public User getById(int id){
        return dao.getById(id);
    }

    public void update(User oldUser, User newUser){
        User user = dao.getById(oldUser.getId());
        user.setAge(newUser.getAge());
        user.setName(newUser.getName());
        dao.save(user);
    }


    public User getByName(String name){
        List<User> list = dao.getAll();
        Optional<User> opt = list.stream().filter(u->u.getName().equals(name)).findFirst();
        return opt.orElse(new User());

    }
}
