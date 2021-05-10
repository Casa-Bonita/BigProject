package ru.study.homework.spring_repository.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
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

    public Parcel() {
    }

    public Parcel(@NonNull String parcelName, @NonNull String address, @NonNull String recipientName) {
        this.parcelName = parcelName;
        this.address = address;
        this.recipientName = recipientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParcelName() {
        return parcelName;
    }

    public void setParcelName(String parcelName) {
        this.parcelName = parcelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
}
