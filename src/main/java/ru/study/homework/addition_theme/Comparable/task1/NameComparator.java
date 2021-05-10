package ru.study.homework.addition_theme.Comparable.task1;

import java.util.Comparator;

public class NameComparator implements Comparator<Planet> {

    private int index;

    public NameComparator(int index) {
        this.index = index;
    }

    public int compare(Planet p1, Planet p2){
        String name1 = p1.getName().toLowerCase();
        String name2 = p2.getName().toLowerCase();

        if(index == 1){
            return name1.compareTo(name2);
        }
        else{
            return name2.compareTo(name1);
        }

    }
}