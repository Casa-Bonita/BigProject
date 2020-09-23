package ru.study.homework.differenttasks.task1;

public class Player {
    private String name;
    private int baseAttack;
    private int additionalAttack;

    public Player(String name, int baseAttack) {
        this.name = name;
        this.baseAttack = baseAttack;
    }

    public Player(String name, int baseAttack, int additionalAttack) {
        this.name = name;
        this.baseAttack = baseAttack;
        this.additionalAttack = additionalAttack;
    }

    public void attack() {
        System.out.println(toString() + "Я атакую.");
    }

    @Override
    public String toString() {
        return name + " использует базовую атаку силой " + baseAttack + " единиц." ;
    }
}
