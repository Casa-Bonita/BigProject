package ru.study.lesson.java8.stream.ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<University> universities = new ArrayList<>();
        universities.add(new University());
        universities.add(new University());


        //1. Получить список студентов, чей возраст больше 14
        List<Student> students1 = universities.stream() //стрим по унив -> стрим по коллекции студентов -> стрим по стриму студентов, а map делает из него стрим по студентам
                .map(university -> university.getStudents()) //принимает Stream<University> -> возвращает Stream<List<Student>>
                //Stream<Stream<Student>> -> Stream<Student>
                .flatMap(list -> list.stream()) //принимает Stream<List<Student>>, мы этот список конвертирует в Stream<Student>, получается
                //Stream<Stream<Student>> после list.stream и flatMap его упрощает и возвращает Stream<Student>
                .filter(student -> student.getAge() > 14)
                .collect(Collectors.toList());

        System.out.println(students1);

    }
}
