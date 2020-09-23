package ru.study.homework.spring;

import org.springframework.beans.factory.annotation.Autowired;
import ru.study.homework.spring.service.CarService;
import ru.study.homework.spring.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputCar {

    @Autowired
    CarService carService;

    public void inputCar(){
        String input = "";
        Scanner scn = new Scanner(System.in);

        Car car = new Car();
        List<Car> listCar = new ArrayList<>();

        while(!input.equals("6")){
            System.out.println("1. Create.");
            System.out.println("2. Read all.");
            System.out.println("3. Read by index.");
            System.out.println("4. Update.");
            System.out.println("5. Delete.");
            System.out.println("6. Exit.");
            input = scn.nextLine();

            if(input.equals("1")){
                System.out.println("1. Create.");
                Car car1 = new Car (1, "Renault", "Logan", 10000);
                Car car2 = new Car (2, "KIA", "Optima", 15000);
                Car car3 = new Car (3, "AvtoVAZ", "Vesta", 20000);
                Car car4 = new Car(4, "Ford", "Focus", 25000);
                listCar.add(car1);
                listCar.add(car2);
                listCar.add(car3);
                listCar.add(car4);

                carService.save(listCar);

            }
            else if(input.equals("2")){
                System.out.println("2. Read all.");

                listCar = carService.getAll();

                listCar.stream()
                        .forEach(x -> System.out.println(x.getId() + "  " + x.getAutoMaker() + "  " + x.getModel() + "  " + x.getPrice()));

            }
            else if(input.equals("3")){
                System.out.println("3. Read by index.");
                System.out.println("\n" + "Введите id автомобиля.");

                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);
                car = carService.getById(inputId);
                System.out.println(car.getId() + "  " + car.getAutoMaker() + "  " + car.getModel() + "  " + car.getPrice());

            }
            else if(input.equals("4")){
                System.out.println("4. Update.");
                System.out.println("\n" + "Введите id автомобиля, который будет изменён.");
                int inputId = scn.nextInt();

                System.out.println("Будет заменен автомобиль:");
                Car oldCar = carService.getById(inputId);
                System.out.println(oldCar.getId() + "   " + oldCar.getAutoMaker() + "   " + oldCar.getModel() + "   " + oldCar.getPrice());

                System.out.println("Введите данные нового автомобиля");
                System.out.println("\n" + "Введите автопроизводителя.");
                String newAutomaker = scn.next();
                System.out.println("\n" + "Введите модель.");
                String newModel = scn.next();
                System.out.println("\n" + "Введите цену.");
                int newPrice = scn.nextInt();

                Car newCar = new Car(newAutomaker, newModel, newPrice);

                carService.update(oldCar, newCar);



            }
            else if (input.equals("5")){
                System.out.println("5. Delete.");
                System.out.println("\n" + "Введите id автомобиля, который будет удалён.");
                String temp = scn.nextLine();
                int inputId = Integer.parseInt(temp);

                System.out.println("Будет удалён автомобиль:");
                Car deletedCar = carService.getById(inputId);
                System.out.println(deletedCar.getId() + "   " + deletedCar.getAutoMaker() + "   " + deletedCar.getModel() + "   " + deletedCar.getPrice());

                carService.remove(inputId);

                listCar = carService.getAll();
                listCar.stream()
                        .forEach(x -> System.out.println(x.getId() + "  " + x.getAutoMaker() + "  " + x.getModel() + "  " + x.getPrice()));

            }
            else if(input.equals("6")){
                System.out.println("6. Exit.");

            }
            else{
                System.out.println("Uncorrect input.");
            }
        }
    }
}
