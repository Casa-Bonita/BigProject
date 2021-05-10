package ru.study.lesson.java8.optional.ex1;

public class Tovar {
    public String name;

    public Tovar(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "name='" + name + '\'' +
                '}';
    }
}
