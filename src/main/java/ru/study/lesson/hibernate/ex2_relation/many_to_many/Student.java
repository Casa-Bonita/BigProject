package ru.study.lesson.hibernate.ex2_relation.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentName;

    @ManyToMany(mappedBy = "studentList", fetch = FetchType.EAGER)
    private List<Prepod> prepodList = new ArrayList<>();

    public Student() {

    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Prepod> getPrepodList() {
        return prepodList;
    }

    public void setPrepodList(List<Prepod> prepodList) {
        this.prepodList = prepodList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", prepodList=" + prepodList +
                '}';
    }
}
