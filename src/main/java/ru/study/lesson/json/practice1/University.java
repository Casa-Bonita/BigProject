package ru.study.lesson.json.practice1;

import java.util.List;

public class University {
    String name;
    List<Student> list;

    public University(String name, List<Student> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
