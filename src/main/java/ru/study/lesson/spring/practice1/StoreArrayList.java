package ru.study.lesson.spring.practice1;

import java.util.ArrayList;

public class StoreArrayList extends ArrayList<String> {

    @Override
    public String get(int index) {
        return "get from list";
    }
}
