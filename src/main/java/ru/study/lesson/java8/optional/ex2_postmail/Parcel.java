package ru.study.lesson.java8.optional.ex2_postmail;

public class Parcel {
    String name;

    public Parcel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "name='" + name + '\'' +
                '}';
    }
}
