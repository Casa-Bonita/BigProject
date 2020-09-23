package ru.study.homework.spring_repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.study.homework.spring_repository.entity.Parcel;

import java.util.List;

public interface ParcelRepository extends CrudRepository <Parcel, Integer> {
    //named query
    List<Parcel> getParcelByParcelName(String name);
    Parcel getParcelByParcelNameAndRecipientName(String name, String receip);

}
