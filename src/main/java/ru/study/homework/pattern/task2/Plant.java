package ru.study.homework.pattern.task2;

import java.util.*;

public class Plant {
    private List<Product> productList;
    private static Plant plant;

    private Plant(){
        productList = new ArrayList<>();
    }

    public static Plant getInstance(){
        if(plant == null){
            plant = new Plant();
        }
        return plant;
    }

    public int orderProducts(Product product, int count){

        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).equals(product)){
                Product productFromPlant = productList.get(i);
                if(productFromPlant.getBalanceAtPlant() < count){
                    count = productFromPlant.getBalanceAtPlant();
                }
                productFromPlant.setBalanceAtPlant(productFromPlant.getBalanceAtPlant() - count);
            }
        }
        return count;

    }

    public void add(Product product){
        productList.add(product);
    }

    public Product get(int index){
        return productList.get(index);
    }
}
