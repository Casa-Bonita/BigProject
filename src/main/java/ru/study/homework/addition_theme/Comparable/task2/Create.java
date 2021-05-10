package ru.study.homework.addition_theme.Comparable.task2;

import java.util.ArrayList;
import java.util.List;

public class Create {
    private List<RealEstate> list = new ArrayList<>();

    public List<RealEstate> create(){

        list.add(new RealEstate(100, 50, 2));
        list.add(new RealEstate(100, 50, 3));
        list.add(new RealEstate(100, 50, 4));

        list.add(new RealEstate(100, 60, 2));
        list.add(new RealEstate(100, 60, 3));
        list.add(new RealEstate(100, 60, 4));

        list.add(new RealEstate(110, 50, 2));
        list.add(new RealEstate(110, 50, 3));
        list.add(new RealEstate(110, 50, 4));

        list.add(new RealEstate(110, 60, 2));
        list.add(new RealEstate(110, 60, 3));
        list.add(new RealEstate(110, 60, 4));

        return list;
    }

    public void print (List<RealEstate> list){
        for(RealEstate re : list){
            System.out.printf("%-10s %-10s %-10s %n", re.getPrice(), re.getSquare(), re.getRooms());
        }
    }
}
