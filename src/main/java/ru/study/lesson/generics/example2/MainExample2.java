package ru.study.lesson.generics.example2;

import java.util.List;

public class MainExample2 {
    public static void main(String[] args) {
        List<Integer> list1 = SimpleClass.getList(1,2,10,-1);
        List<String> list2 = SimpleClass.getList("one", "two");



    }
}
