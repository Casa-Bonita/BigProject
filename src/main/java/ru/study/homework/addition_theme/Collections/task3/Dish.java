package ru.study.homework.addition_theme.Collections.task3;

import java.util.ArrayList;
import java.util.Objects;

public class Dish {
//    Создать класс Dish (блюдо) с private полями:
//    - название блюда;
//    - цена блюда.
//    Переопределить метод toString.
//    Переопределить equals и hashCode, чтобы HashSet мог понимать, как объекты класса Dish являются дубликатами.
//    Остальную структуру класса Dish дополнить самостоятельно по необходимости.

    private String name;
    private int price;

    public Dish() {
    }

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Dish create(int i){
        String dishName = "";
        if(i < 10){
            dishName= "Dish-0" + i;
        }
        else{
            dishName = "Dish-" + i;
        }

        int price = (i + 1) * 2;
        return new Dish(dishName, price);
    }

    public ArrayList<Dish> dishSort(ArrayList<Dish> orders){
        for (int k = 0; k < orders.size(); k++) {
            Dish dishMin = orders.get(k);
            int indexMin = k;
            for (int j = k; j < orders.size() ; j++) {
                Dish dishCurrent = orders.get(j);
                //dishCurrent.getName().compareTo(dishMin.getName())
                String[] arraydishCurrent = dishCurrent.getName().split("-");
                String[] arraydishMin = dishMin.getName().split("-");
                if(Integer.parseInt(arraydishCurrent[1]) < Integer.parseInt(arraydishMin[1])){
                    dishMin = dishCurrent;
                    indexMin = j;
                }
            }
            Dish tmp = orders.get(k);
            orders.set(k, dishMin);
            orders.set(indexMin, tmp);
        }
        return orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name = " + name + ", price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return price == dish.price && Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + price * 31;
        return result;
    }
}
