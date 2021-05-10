package ru.study.homework.addition_theme.Collections.task4;

public class Address {
//    Создать класс Address с private полями:
//    - город;
//    - улица;
//    - дом;
//    - квартира.
//    Остальную структуру Address нужно дописать по необходимости.

    private String city;
    private String street;
    private int house;
    private int apartment;

    public Address() {
    }

    public Address(String city, String street, int house, int apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "city = " + city + ", street = " + street + ", house = " + house + ", apartment = " + apartment;
    }
}
