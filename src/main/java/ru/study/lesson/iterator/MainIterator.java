package ru.study.lesson.iterator;

import java.util.Iterator;

public class MainIterator {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("for each");
        for(Integer val : list ){
            System.out.println(val);
        }

        System.out.println("iterator:");
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }


    }
}
