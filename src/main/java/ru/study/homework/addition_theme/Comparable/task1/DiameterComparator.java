package ru.study.homework.addition_theme.Comparable.task1;

import java.util.Comparator;

public class DiameterComparator implements Comparator<Planet> {

    int index;

    public DiameterComparator(int index) {
        this.index = index;
    }

    public int compare(Planet p1, Planet p2){
        switch (index){
            case 1:
                if (p1.getDiameter() == p2.getDiameter()) {
                    return 0;
                }
                else if (p1.getDiameter() > p2.getDiameter()){
                    return 1;
                }
                else{
                    return -1;
                }

            case 0:
                if (p1.getDiameter() == p2.getDiameter()) {
                    return 0;
                }
                else if (p1.getDiameter() < p2.getDiameter()){
                    return 1;
                }
                else{
                    return -1;
                }

            default:
                break;
        }
        return 0;
    }
}