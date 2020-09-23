package ru.study.lesson.generics.practice1;

public class SuperContainer<T> {
    private T name;

    public SuperContainer(T name) {
        this.name = name;
    }

    public T getName (){
        return name;
    }

    public boolean contains(T test){
        return name.equals(test);
    }
}
