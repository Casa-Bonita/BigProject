package ru.study.lesson.spring.ex3_repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.study.lesson.spring.ex3_repository.entity.Passport;
import ru.study.lesson.spring.ex3_repository.repo.PassportRepo;

import java.util.List;

@Service
public class PassportService {

    @Autowired
    private PassportRepo passportRepo;

    public void save(Passport passport){
        passportRepo.save(passport);
    }

    public List<Passport> getAll(){
        return (List<Passport>)passportRepo.findAll();
    }

}
