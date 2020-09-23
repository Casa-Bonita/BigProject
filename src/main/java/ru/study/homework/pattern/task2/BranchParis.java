package ru.study.homework.pattern.task2;

public class BranchParis {
    private Plant plant;

    public BranchParis(){
        this.plant = Plant.getInstance();
    }

    public void add(Product product){
        plant.add(product);
    }
}

