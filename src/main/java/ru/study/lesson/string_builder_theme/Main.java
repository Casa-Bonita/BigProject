package ru.study.lesson.string_builder_theme;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hello").append(" ").append("world");

        System.out.println(sb);

        Subject s1 = new Subject("subject1", 5);
        Subject s2 = new Subject("subject2", 4);
        Student st1 = new Student("Ivan");
        st1.subjectList.add(s1);
        st1.subjectList.add(s2);

        Student st2 = new Student("Petr");
        st2.subjectList.add(s1);
        st2.subjectList.add(s2);
        University university = new University("Garvard");
        university.students.add(st1);
        university.students.add(st2);

        System.out.println(university);
    }
}

class University{
    String name;
    private static long serialVersionUID = 1L;
    List<Student> students = new ArrayList<>();


    public University(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Универ: ").append(name).append("\n");
        for(Student st : students){
            sb.append(st.toString()).append("\n");
        }
        return sb.toString();
    }
}

class Student{
    String name;
    List<Subject> subjectList = new ArrayList<>();
    private static long serialVersionUID = 1L;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Студент: ").append(name).append("\n");
        for(Subject sub : subjectList){
            sb.append(sub.toString()).append("\n");
        }
        return sb.toString();
    }
}


class Subject{
    String name;
    int mark;
    private static long serialVersionUID = 1L;

    public Subject(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Предмет: "+ name + ", Оценка:  " +mark;
    }
}