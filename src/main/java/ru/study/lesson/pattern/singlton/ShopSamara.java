package ru.study.lesson.pattern.singlton;

public class ShopSamara {
    private TovarStore tovarStore;

    public ShopSamara(TovarStore tovarStore) {
        this.tovarStore = tovarStore;
    }

    public void add(Tovar tovar){
        tovarStore.add(tovar);
    }
}
