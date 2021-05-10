package ru.study.homework.addition_theme.Comparable.task2;

import java.util.Comparator;

public class RealEstateComparator implements Comparator<RealEstate> {
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

    public RealEstateComparator() {
    }


    public int compare (RealEstate r1, RealEstate r2){
        int priceDiff = r1.getPrice() - r2.getPrice();
        if(priceDiff!=0){
            return priceDiff;
        }
        int squareDiff = r1.getSquare() - r2.getSquare();
        if(squareDiff!=0) {
            return squareDiff;
        }
        int roomCount = r1.getRooms() - r2.getRooms();
        return roomCount;


    }

//    public int compare (RealEstate r1, RealEstate r2){
//        if (r1.getPrice() == r2.getPrice()){
//            if(r1.getSquare() == r2.getSquare()){
//                if(r1.getRooms() == r2.getRooms()){
//                    return 0;
//                }
//                else if(r1.getRooms() > r2.getRooms()){
//                    return -1;
//                }
//                else{
//                    return 1;
//                }
//            }
//            else if(r1.getSquare() < r2.getSquare()){
//                return 1;
//            }
//            else{
//                return -1;
//            }
//        }
//        else if(r1.getPrice() > r2.getPrice()){
//            return 1;
//        }
//        else{
//            return -1;
//        }
//    }
}
