package ru.study.lesson.spring.ex3_repository.repo;

import org.springframework.data.repository.CrudRepository;
import ru.study.lesson.spring.ex3_repository.entity.Passport;

public interface PassportRepo extends CrudRepository<Passport, Integer> {
}
