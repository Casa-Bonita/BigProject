package ru.study.lesson.pattern.singlton;

import java.util.ArrayList;
import java.util.List;

//склад товаров
public class TovarStore {
    private List<Tovar> store;
    private static TovarStore tovarStore;
    private TovarStore(){
        store = new ArrayList<>();
    }

    public static TovarStore getInstance(){
        if(tovarStore == null){
            tovarStore = new TovarStore();
        }
        return tovarStore;
    }

    public void add(Tovar tovar){
        store.add(tovar);
    }

    public Tovar get(int index){
        return store.get(index);
    }


}
