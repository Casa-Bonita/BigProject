package ru.study.homework.spring_repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.study.homework.spring_repository.entity.Parcel;
import ru.study.homework.spring_repository.service.ParcelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//    Создать сущность Parcel (посылка) с полями id, наименование, адрес назначения, имя получателя.
//    Реализовать репозиторий с базовыми crud действиями, используя spring, jpa, spring data.
//    Реализовать методы:
//    - сохранение посылок в базе;
//    - получение всех посылок;
//    - получение посылки по id;
//    - удаление посылки.

        List<Parcel> listParcel = new ArrayList<>();

        Scanner scn = new Scanner(System.in);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        ParcelService service = context.getBean(ParcelService.class);

        String input = "";
        while(!input.equals("6")){
            System.out.println("1. Create.");
            System.out.println("2. Read.");
            System.out.println("3. Read By Id.");
            System.out.println("4. Update.");
            System.out.println("5. Delete.");
            System.out.println("6. Exit.");
            System.out.println("7. Get parcel by name and receip.");

            input = scn.nextLine();
            if(input.equals("1")){
                System.out.println("1. Create.");

                service.save(new Parcel("parcel_1", "Ivan", "Moscow"));
                service.save(new Parcel("parcel_2", "Oleg", "Rostov"));
                service.save(new Parcel("parcel_3", "Marina", "Samara"));
                service.save(new Parcel("parcel_4", "Olga", "Irkutsk"));
                service.save(new Parcel("parcel_5", "Petr", "Tomsk"));
                service.save(new Parcel("parcel_6", "Elena", "Krasnodar"));
                listParcel = service.getAll();
            }

            else if(input.equals("2")){
                System.out.println("2. Read.");

                listParcel = service.getAll();
                listParcel.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

            }

            else if(input.equals("3")){
                System.out.println("3. Read By Id.");

                System.out.println("Посылки, имещиеся в таблице:");
                listParcel = service.getAll();
                listParcel.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

                System.out.println("Введите id посылки, которую нужно найти:");
                String inputId = scn.nextLine();
                int id = Integer.parseInt(inputId);

                Parcel parcel = service.getById(id).get();

                System.out.printf("%-20s %-20s %-20s %-20s %n", parcel.getId(), parcel.getParcelName(), parcel.getAddress(), parcel.getRecipientName());

            }

            else if(input.equals("4")){
                System.out.println("4. Update.");

                System.out.println("Посылки, имещиеся в таблице:");
                listParcel.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

                System.out.println("Введите название посылки, которая будет изменена:");
                String inputParcelName = scn.nextLine();

                System.out.println("Введите новый адрес:");
                String newAddress = scn.nextLine();

                System.out.println("Введите нового получателя:");
                String newRecipientName = scn.nextLine();

                int id = 0;


//                for (int i = 0; i < listParcel.size(); i++) {
//                    String tempParcelName = listParcel.get(i).getParcelName();
//                    if(inputParcelName.equals(tempParcelName)){
//                        id = listParcel.get(i).getId();
//                    }
//                }
                id = service.getParcelByName(inputParcelName).get(0).getId();


                Parcel changedParcel = service.getById(id).get();
//                final Parcel parcel = new Parcel(changedParcel.getParcelName(), newAddress, newRecipientName);
//                parcel.setId(id);
                changedParcel.setAddress(newAddress);
                changedParcel.setRecipientName(newRecipientName);
                // как сделать, чтобы этот код не выполнялся если выполнится finally
                service.save(changedParcel);
                System.out.println("Посылки после изменения:");
                service.getAll().stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

            }

            else if(input.equals("5")){
                System.out.println("5. Delete.");

                System.out.println("Посылки, имещиеся в таблице:");
                listParcel.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

                System.out.println("Введите название посылки, которая будет удалена:");
                String inputParcelName = scn.nextLine();

                int id = -1;

                Parcel tempParcel = new Parcel();
                for (int i = 0; i < listParcel.size(); i++) {
                    String tempParcelName = tempParcel.getParcelName();
                    if(inputParcelName.equals(tempParcelName)){
                        id = tempParcel.getId();
                    }
                }

                try{
                    service.delete(id);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    System.out.println("Посылки не удалились:");
                    listParcel.stream()
                            .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));
                }

                System.out.println("Посылки после удаления:");
                listParcel.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getId(), x.getParcelName(), x.getAddress(), x.getRecipientName()));

            }

            else if(input.equals("6")){
                System.out.println("6. Exit.");

            }else if(input.equals("7")){
                System.out.println("Enter name");
                String name = scn.nextLine();
                System.out.println("Enter receip");
                String receip = scn.nextLine();
                final Parcel parcel = service.getParcelByNameAndReceip(name, receip);
                System.out.println(parcel.getParcelName()+" "+parcel.getRecipientName());

            }

            else{
                System.out.println("Invalid input.");

            }
        }


    }
}
