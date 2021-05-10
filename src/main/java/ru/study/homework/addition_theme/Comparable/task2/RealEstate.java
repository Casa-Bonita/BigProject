package ru.study.homework.addition_theme.Comparable.task2;

import ru.study.homework.addition_theme.Comparable.task1.Planet1;

public class RealEstate implements Comparable<RealEstate>{
//    Реализовать интерфейс Comparable и сортировку, где сначала выполняется сортировка по возрастанию цены,
//    если цена совпадает, то по убыванию площади (так как по одинаковой цене лучше купить недвижимость побольше).
//    Если совпадает и площадь, то по убыванию количества комнат.
//
//    К примеру, имеется набор объектов недвижимости:
//    - Цена: 100, Площадь: 50, Количество комнат: 3;
//    - Цена: 100, Площадь: 60, Количество комнат: 2;
//    - Цена: 100, Площадь: 50, Количество комнат: 4.
//
//    Они должны быть отсортированы следующим образом:
//    - Цена: 100, Площадь: 60, Количество комнат: 2;
//    - Цена: 100, Площадь: 50, Количество комнат: 4;
//    - Цена: 100, Площадь: 50, Количество комнат: 3.

    private int price;
    private int square;
    private int rooms;

    public RealEstate() {
    }

    public RealEstate(int price, int square, int rooms) {
        this.price = price;
        this.square = square;
        this.rooms = rooms;
    }

    public int getPrice() {
        return price;
    }

    public int getSquare() {
        return square;
    }

    public int getRooms() {
        return rooms;
    }

    public int compareTo(RealEstate anotherRealEstate){
        if (this.price == anotherRealEstate.price){
            if(this.square == anotherRealEstate.square){
                if(this.rooms == anotherRealEstate.rooms){
                    return 0;
                }
                else if(this.rooms > anotherRealEstate.rooms){
                    return -1;
                }
                else{
                    return 1;
                }
            }
            else if(this.square < anotherRealEstate.square){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(this.price > anotherRealEstate.price){
            return 1;
        }
        else{
            return -1;
        }
    }
}
