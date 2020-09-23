package ru.study.homework.DAO;

import ru.study.homework.DAO.model.Car;
import ru.study.homework.DAO.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputCar {

    public void inputCar(){
        Scanner scn = new Scanner(System.in);
        String input = "";

        Car car = new Car();
        CarService carService = new CarService();
        List<Car> listCar = new ArrayList<>();

        while(!input.equals("5")){
            System.out.println("1. Create.");
            System.out.println("2. Read.");
            System.out.println("3. Update.");
            System.out.println("4. Delete.");
            System.out.println("5. Exit.");
            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Create.");
                Car car1 = new Car(1, "Lada", "Vesta");
                Car car2 = new Car(2, "Ford", "Mondeo");
                Car car3 = new Car(3, "Nissan", "X-Trail");
                Car car4 = new Car(4, "KIA", "RIO");
                listCar.add(car1);
                listCar.add(car2);
                listCar.add(car3);
                listCar.add(car4);

                carService.save(listCar);

            }
            else if(input.equals("2")){
                System.out.println("2. Read.");

                System.out.println("Вывести все данные? y/n");
                String inputData = scn.nextLine();

                if(inputData.equals("y")){
                    listCar = carService.getAll();
                    listCar.stream()
                            .forEach(x -> System.out.println(x.getId() + "   " + x.getAutoMaker() + "   " + x.getModel()));
                }

                else if(inputData.equals("n")){
                    System.out.println("Введите id автомобиля, который будет считан");
                    String temp = scn.nextLine();
                    int inputId = Integer.parseInt(temp);
                    car = carService.getById(inputId);
                    System.out.println(car.getId() + "   " + car.getAutoMaker() + "   " + car.getModel());
                }

            }
            else if(input.equals("3")){
                System.out.println("3. Update.");
                System.out.println("Введите id автомобиля, который будет заменен:");
                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);

                System.out.println("Будет заменен автомобиль:");
                Car oldCar = carService.getById(inputId);
                System.out.println(oldCar.getId() + "   " + oldCar.getAutoMaker() + "   " + oldCar.getModel());

                System.out.println("Введите данные нового автомобиля");
                System.out.println("Введите название автопроизводителя:");
                String newAutoMaker = scn.nextLine();
                System.out.println("Введите название модели:");
                String newModel = scn.nextLine();
                Car newCar = new Car (inputId, newAutoMaker, newModel);

                carService.update(oldCar, newCar);
                listCar = carService.getAll();
                listCar.stream()
                        .forEach(x -> System.out.println(x.getId() + "   " + x.getAutoMaker() + "   " + x.getModel()));

            }
            else if(input.equals("4")){
                System.out.println("4. Delete.");
                System.out.println("Введите id автомобиля, который будет удален");
                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);
                Car deletedCar = carService.getById(inputId);
                carService.delete(deletedCar);

            }
            else if(input.equals("5")){
                System.out.println("5. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");
            }
        }

    }
}
