package ru.study.homework.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import ru.study.homework.spring.dao.CarDao_FileImpl;
import ru.study.homework.spring.dao.DAO;
import ru.study.homework.spring.model.Car;

import java.util.List;

public class CarService {

    String pathFile = "src/main/java/ru/study/homework/spring/fileCar.txt";


    DAO<Car> dao;


    public CarService(DAO<Car> dao) {
        this.dao = dao;
    }

    public void save (List<Car> listCar){
        dao.save(listCar);
    }

    public List<Car> getAll(){
        List<Car> listCar = dao.getAll();
        return listCar;
    }

    public Car getById(int index){
        return dao.getById(index);
    }

    public void update (Car oldCar, Car newCar){
//        List<Car> listCar = dao.getAll();
//        int index = 0;
//        for (int i = 0; i < listCar.size(); i++) {
//            if(listCar.get(i).getId() == oldCar.getId()){
//                index = i;
//            }
//        }
//
//        Car updateCar = dao.getById(oldCar.getId());
//        updateCar.setAutoMaker(newCar.getAutoMaker());
//        updateCar.setModel(newCar.getAutoMaker());
//        updateCar.setPrice(newCar.getPrice());
//        listCar.remove(index);
//        listCar.add(updateCar);
//        dao.save(listCar);
        dao.update(oldCar, newCar);
    }

    public void remove(int id){
//        List<Car> listCar = dao.getAll();
//        for (int i = 0; i < listCar.size(); i++) {
//            if(listCar.get(i).getId() == id){
//                listCar.remove(i);
//            }
//        }
//        dao.save(listCar);
        dao.remove(id);

    }
}
