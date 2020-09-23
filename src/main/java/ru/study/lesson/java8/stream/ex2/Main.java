package ru.study.lesson.java8.stream.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("Ivan", 19));
        listStudent.add(new Student("Ivan2", 11));
        listStudent.add(new Student("Ivan3", 12));
        listStudent.add(new Student("Ivan4", 13));


        listStudent.stream()
                .forEach(System.out::println);


        //Получить коллекцию имен студентов
        List<String> listNames = listStudent.stream()
                .map(x->x.name) //return Stream<String>
                .collect(Collectors.toList());
        System.out.println(listNames);


        //Получить колекцию возрастов студентов, чей возраст больше 15
        List<Integer> listAge = listStudent.stream()
                .map(student->student.age)
                .filter(age->age>15)
                .collect(Collectors.toList());
        System.out.println(listAge);


    }
}
