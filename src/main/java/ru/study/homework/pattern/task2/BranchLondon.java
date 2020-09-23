package ru.study.homework.pattern.task2;

import java.util.ArrayList;
import java.util.List;

public class BranchLondon {
    private Plant plant;
    private List<Product> productList = new ArrayList();
    public BranchLondon(){
        this.plant = Plant.getInstance();
    }

    public void add(Product product){
        productList.add(product);
    }

    public void makeOrder(){
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if(product.getBalanceAtPlant() < 10){
                int count = plant.orderProducts(product, 10);
                product.setBalanceAtPlant(product.getBalanceAtPlant()+count);
            }
        }
    }
}
