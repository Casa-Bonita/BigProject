package ru.study.homework.DAO.dao;

import ru.study.homework.DAO.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao_FileImpl implements DAO<Car>{

    private String pathFile;

    public CarDao_FileImpl(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void save(List<Car> listCar) {
        BufferedWriter bw = null;
        Car tempCar = new Car();
        try{
            bw = new BufferedWriter(new FileWriter(pathFile));
            for (int i = 0; i < listCar.size(); i++) {
                tempCar = listCar.get(i);
                String line = tempCar.getId() + ";" + tempCar.getAutoMaker() + ";" + tempCar.getModel() + ";";
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }finally{
            if(bw != null){
                try{
                    bw.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Car> getAll() {
        List<Car> listCar = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(pathFile));
            line = br.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                Car car = new Car(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
                listCar.add(car);
                line = br.readLine();
            }
            br.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return listCar;
    }

    @Override
    public Car getById(int id) {
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(pathFile));
            line = br.readLine();
            while(line != null){
                String[] lineSplit = line.split(";");
                if(Integer.parseInt(lineSplit[0]) == id){
                    Car car = new Car(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
                    br.close();
                    return car;
                }
                line = br.readLine();
            }
            br.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Car oldT, Car newT) {

    }

    @Override
    public void delete(Car car) {

    }
}