package ru.study.homework.atomic.task1;

import java.util.*;

public class DishWasher{

    private List<Plate> listPlate;

    public DishWasher(){

    }

    public synchronized void startWash(List<Plate> listPlate, int i){
        this.listPlate = listPlate;

        Plate plate = new Plate();
        plate = listPlate.get(i);
        System.out.println(plate.getName() + " помыта!");
        listPlate.remove(i);
    }

}
