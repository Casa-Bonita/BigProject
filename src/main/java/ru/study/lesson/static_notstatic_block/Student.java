package ru.study.lesson.static_notstatic_block;

public class Student {
    int age;
    String name;
    static String university;


    public static void printUniversity(){
        System.out.println(university);
    }

    static{
        System.out.println("статический блок");
        university = "Garvard";
    }

    {
        age = 18;
        name = "Ivan";
        System.out.println("Нестатический блок");
    }


    public Student(){
        age = 18;
        name = "Ivan";
        System.out.println("Constructor");
    }


    public Student(int age, String name) {
        System.out.println("Constructor");
        this.age = age;
        this.name = name;
    }
}
