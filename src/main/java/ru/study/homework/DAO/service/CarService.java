package ru.study.homework.DAO.service;

import ru.study.homework.DAO.dao.CarDao_FileImpl;
import ru.study.homework.DAO.dao.DAO;
import ru.study.homework.DAO.model.Car;

import java.util.List;

public class CarService {

    String pathFile = "src/main/java/ru/study/homework/DAO/fileCar.txt";

    DAO<Car> dao = new CarDao_FileImpl(pathFile);



    public void save (List<Car> listCar){
        dao.save(listCar);
    }

    public List<Car> getAll(){
        List<Car> listCar = dao.getAll();
        return listCar;
    }

    public Car getById(int id){
        return dao.getById(id);
    }

    public void update(Car oldCar, Car newCar){
        List<Car> listCar = dao.getAll();
        int index = 0;
        for (int i = 0; i < listCar.size(); i++) {
            if(listCar.get(i).getId() == oldCar.getId()){
                index = i;
            }
        }
        Car car = dao.getById(oldCar.getId());
        car.setAutoMaker(newCar.getAutoMaker());
        car.setModel(newCar.getModel());
        listCar.remove(index);
        listCar.add(car);
        dao.save(listCar);
    }

    public void delete(Car car){
        List<Car> listCar = dao.getAll();
        for (int i = 0; i < listCar.size(); i++) {
            if(listCar.get(i).getId() == car.getId()){
                listCar.remove(i);
            }
        }
        dao.save(listCar);
    }

}
