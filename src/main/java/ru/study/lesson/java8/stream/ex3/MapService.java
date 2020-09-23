package ru.study.lesson.java8.stream.ex3;

public class MapService<T,R> {
    private T t;

    public MapService(T t) {
        this.t = t;
    }

    public R map(Consumer<T,R> convert){
        return convert.consume(t);
    }
}
