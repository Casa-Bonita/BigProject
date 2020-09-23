package ru.study.lesson.generics.example2;



import java.util.Arrays;
import java.util.List;

public class SimpleClass {
    public static <T> List<T> getList(T...vals){
        List<T> list = Arrays.asList(vals);
        return list;
    }
}
