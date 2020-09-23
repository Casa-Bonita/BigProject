package ru.study.homework.differenttasks.task1;

import java.util.*;

public class Wizard extends Player{

    public Wizard(String name, int baseAttack){
        super(name, baseAttack);
    }

    public Wizard(String name, int baseAttack, int magicalAttack){
        super(name, baseAttack, magicalAttack);
    }

    Random rnd = new Random();
    int magicalAttack = rnd.nextInt(4) + 1;

    @Override
    public void attack() {
        System.out.println(toString() + " Он атакует базовой атакой!");
    }
}
