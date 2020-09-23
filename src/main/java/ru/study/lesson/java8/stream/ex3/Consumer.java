package ru.study.lesson.java8.stream.ex3;

public interface Consumer<T, R> {
    R consume(T t);
}
