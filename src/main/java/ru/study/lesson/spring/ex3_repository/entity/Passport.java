package ru.study.lesson.spring.ex3_repository.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor //создаем конструктор для полей, которые помечены аннотацией NonNull или являются final
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;
    @NonNull
    private int seria;
    @NonNull
    private int number;
    @NonNull
    private String name;

}
