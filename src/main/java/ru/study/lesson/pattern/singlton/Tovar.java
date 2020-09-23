package ru.study.lesson.pattern.singlton;

public class Tovar {
    private String name;
    private int countOnStore;

    public Tovar(String name, int countOnStore) {
        this.name = name;
        this.countOnStore = countOnStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOnStore() {
        return countOnStore;
    }

    public void setCountOnStore(int countOnStore) {
        this.countOnStore = countOnStore;
    }

    @Override
    public String toString() {
        return "Tovar{" +
                "countOnStore=" + countOnStore +
                '}';
    }
}
