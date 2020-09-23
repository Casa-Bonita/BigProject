package ru.study.homework.spring_repository.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Parcel {

//    Создать сущность Parcel (посылка) с полями id, наименование, адрес назначения, имя получателя.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @NonNull
    private String parcelName;

    @NonNull
    private String address;

    @NonNull
    private String recipientName;
}
