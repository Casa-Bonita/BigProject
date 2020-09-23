package ru.study.lesson.dao_pattern.dao;

import ru.study.lesson.dao_pattern.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoArrayListImpl implements Dao<User> {
    List<User> listUser = new ArrayList<>();

    @Override
    public void save(User user) {
        listUser.add(user);

    }

    @Override
    public User getById(int id) {
        Optional<User> opt = listUser.stream().filter(user -> user.getId() == id).findFirst();
        if(opt.isPresent()){
            return opt.get();
        }
        return new User();
    }


    @Override
    public List<User> getAll() {
        return null;
    }



    @Override
    public void remove(User user) {

    }
}
