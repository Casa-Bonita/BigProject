package ru.study.lesson.hibernate.ex2_relation.many_to_many;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Prepod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prepodName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name="prepod_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> studentList = new ArrayList<>();

    public Prepod() {
    }
    public Prepod(String prepodName) {
        this.prepodName = prepodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrepodName() {
        return prepodName;
    }

    public void setPrepodName(String prepodName) {
        this.prepodName = prepodName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Prepod{" +
                "id=" + id +
                ", prepodName='" + prepodName;
    }
}
