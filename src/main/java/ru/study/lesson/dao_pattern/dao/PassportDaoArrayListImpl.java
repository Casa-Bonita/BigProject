package ru.study.lesson.dao_pattern.dao;

import ru.study.lesson.dao_pattern.model.Passport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassportDaoArrayListImpl implements Dao<Passport> {

    private List<Passport> passportList = new ArrayList<>();


    @Override
    public void save(Passport passport) {
        passportList.add(passport);
    }

    @Override
    public Passport getById(int id) {
        Optional<Passport> opt = passportList.stream().filter(passport -> passport.getId() == id).findFirst();
        return opt.orElse(new Passport());
    }



    @Override
    public List<Passport> getAll() {
        return null;
    }



    @Override
    public void remove(Passport passport) {

    }
}
