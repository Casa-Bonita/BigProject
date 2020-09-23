package ru.study.lesson.java8.stream.ex4;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    {
        students.add(new Student("Ivan", 19));
        students.add(new Student("Ivan2", 11));
        students.add(new Student("Ivan3", 12));
        students.add(new Student("Ivan4", 13));
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
