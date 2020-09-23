package ru.study.lesson.spring.practice1;

import java.util.HashSet;
import java.util.LinkedList;

public class StoreLinkedList extends LinkedList<String> {
    @Override
    public String get(int index) {
        return "get from linked list";
    }
}
