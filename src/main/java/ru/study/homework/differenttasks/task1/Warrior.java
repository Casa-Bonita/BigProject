package ru.study.homework.differenttasks.task1;

import java.util.*;

public class Warrior extends Player {

    public Warrior(String name, int baseAttack){
        super(name, baseAttack);
    }

    public Warrior(String name, int baseAttack, int powerAttack){
        super(name, baseAttack, powerAttack);
    }

    @Override
    public void attack() {
        System.out.println(toString() + " Он атакует базовой атакой!");
    }

}
