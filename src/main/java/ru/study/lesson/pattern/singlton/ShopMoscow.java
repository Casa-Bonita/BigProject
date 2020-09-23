package ru.study.lesson.pattern.singlton;

public class ShopMoscow {
    private TovarStore tovarStore;

    public ShopMoscow(TovarStore tovarStore) {
        this.tovarStore = tovarStore;
    }

    public void add(Tovar tovar){
        tovarStore.add(tovar);
    }

}
