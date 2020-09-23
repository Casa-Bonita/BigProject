package ru.study.homework.differenttasks.task1;

public enum HealthLevel {
    FULL (100),
    NORMAL (50),
    DANGER (15),
    NONE (0);

    int level;

    private HealthLevel (int level){
        this.level = level;
    }

    public int getDescription() {
        return level;
    }

}