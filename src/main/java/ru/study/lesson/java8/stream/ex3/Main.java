package ru.study.lesson.java8.stream.ex3;

public class Main {
    public static void main(String[] args) {
        //Написать свой метод map

        //1. КОнвертировать строку в double
        Consumer<String, Double> map1 = (val)-> Double.valueOf(val);
        double d = map1.consume("12.5");
        System.out.println(d);


        //2. КОнверитровать объект студента в его имя
        Student st = new Student("Petr", 22);

//        IConverter<Student, String> map2 = new IConverter<Student, String>() {
//            @Override
//            public String map(Student student) {
//                return student.getName();
//            }
//        };
        Consumer<Student, String> map2 = (student)-> student.getName();

        System.out.println(map2.consume(st));

        //3. Использовать для конвертации Map
        MapService<Student, String> mapService = new MapService<>(st);
        String name = mapService.map((student)-> student.getName());
        System.out.println(name);


        //4. Конвертация в возраст
        MapService<Student, Integer> mapService2 = new MapService<>(st);
        Integer age = mapService2.map((student)-> student.getAge());
        System.out.println(age);




    }


}
