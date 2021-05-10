package ru.study.homework.addition_theme.Collections.task4;

import ru.study.homework.addition_theme.Collections.task3.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostOffice {
//    Создать класс PostOffice (почтовое отделение) с private полями:
//    - карта типа HashMap, где ключом является адрес, а значением - список посылок (HashMap<Address, ArrayList<Parcel>>).
//    Создать метод startDeliver, который запускаем процесс доставки посылок.
//    Остальную структуру PostOffice нужно дописать по необходимости.

    Map<Address, ArrayList<Parcel>> mapAddressParcel = new HashMap<>();


    public PostOffice() {
    }

    public PostOffice(Map<Address, ArrayList<Parcel>> mapAddressParcel) {
        this.mapAddressParcel = mapAddressParcel;
    }

    public void addParcel(Address address, ArrayList<Parcel> parcelList){
        mapAddressParcel.put(address, parcelList);
    }

    public void startDeliver(){
        System.out.println();
        for(Address adrs : mapAddressParcel.keySet()){
            System.out.println("Для адреса " + adrs + " будут доставлены следующие посылки");
            for(Parcel prcl : mapAddressParcel.get(adrs)){
                System.out.println("  " + prcl);
            }
            System.out.println();
        }
    }


    public Map<Address, ArrayList<Parcel>> getMapAddressParcel() {
        return mapAddressParcel;
    }

    public void setMapAddressParcel(Map<Address, ArrayList<Parcel>> mapAddressParcel) {
        this.mapAddressParcel = mapAddressParcel;
    }

    @Override
    public String toString() {
        return "mapAddressParcel = " + mapAddressParcel;
    }
}
