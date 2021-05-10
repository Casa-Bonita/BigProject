package ru.study.homework.addition_theme.Collections.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//    4. В почтовом отделении у каждого клиента может быть неограниченное количество посылок.
//    Нужно как-то объединить клиентов и принадлежащие им посылки в программе,
//    чтобы, зная адрес клиента, можно было легко получить список принадлежащих ему посылок.
//
//    Создать класс Address с private полями:
//    - город;
//    - улица;
//    - дом;
//    - квартира.
//    Остальную структуру Address нужно дописать по необходимости.
//
//    Создать класс Client с private полями:
//    - имя;
//    - адрес.
//    Остальную структуру Client нужно дописать по необходимости.
//
//    Создать класс Parcel (посылка) с private полями:
//    - название содержимого посылки;
//    - адрес получателя.
//    Остальную структуру Parcel нужно дописать по необходимости.
//
//    Создать класс PostOffice (почтовое отделение) с private полями:
//    - карта типа HashMap, где ключом является адрес, а значением - список посылок (HashMap<Address, ArrayList<Parcel>>).
//    Создать метод startDeliver, который запускаем процесс доставки посылок.
//    Остальную структуру PostOffice нужно дописать по необходимости.
//
//
//    В Main создать клиентов, почтовое отделение, заполнить почтовое отделение посылками и раздать все посылки их клиентам.
//    Сымитировать ситуацию, когда на посылке указан адрес неверно.
//    В этом случае после раздачи посылок нужно вывести список оставшихся посылок с не найденным адресом.

        Address address = new Address();
        Address wrongAddress = new Address();

        Client client = new Client();
        List<Client> clientList = new ArrayList<>();

        Parcel parcel = new Parcel();
        List<Parcel> parcelList = new ArrayList<>();
        ArrayList<Parcel> wrongParcelList = new ArrayList<>();

        PostOffice postOffice = new PostOffice();

        Random rnd = new Random();

        int n = rnd.nextInt(5) + 2; // количество клиентов
        System.out.println("Создано " + n + " клиентов.");

        System.out.println("Создан список клиентов с адресами доставки:");
        // создание списка клиентов
        for (int i = 0; i < n; i++) {
            String clientName = "client-" + i;
            String clientCity = "city-" + i;
            String clientStreet = "street-" + i;
            int clientHouse = i;
            int clientApartment = i * 2;
            address = new Address(clientCity, clientStreet, clientHouse, clientApartment);
            client = new Client(clientName, address);
            clientList.add(client);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %n", clientName, clientCity, clientStreet, clientHouse, clientApartment);
        }

        System.out.println("\n" + "Создан список посылок, с распределением посылок по клиентам:");
        // создание списка посылок (для примера, количество посылок = 25)
        int temp = 0;
        for (int i = 0; i < 25; i++) {
            String content = "parcel_content-" + i;

            // "распределение" посылок по адресам клиентов
            client = clientList.get(temp);
            address = client.getClientAddress();

            parcel = new Parcel(content, address);
            parcelList.add(parcel);

            System.out.println("Посылка " + i + " для " + client.getName());

            temp++;

            if(temp == n){
                temp = 0;
            }
        }

        System.out.println("\n" + "Создан список посылок, с неверными адресами:");
        // создание посылок с неверными адресами (для примера, количество посылок = 5) и добавление их в список
        for (int i = 0; i < 5; i++) {
            String content = "parcel_content-" + "wrong_" + i;
            String city = "city-wrong";
            String street = "street-wrong";
            int house = 0;
            int apartment = 0;

            wrongAddress = new Address(city, street, house, apartment);

            parcel = new Parcel(content, wrongAddress);
            wrongParcelList.add(parcel);

            System.out.println("Посылка " + i + " адрес =   " + city + "   " + street + "   " + house + "   " + apartment);
        }

        // заполнение почтового отделения посылками
        for (int i = 0; i < clientList.size(); i++) {

            // получаем адрес клиента - clientAddress
            client = clientList.get(i);

            // временный список, для хранения посылок одного клиента
            ArrayList<Parcel> tempParcelList = new ArrayList<>();

            // из списка посылок, получаем адреса доставки посылок
            for (int j = 0; j < parcelList.size(); j++) {
                parcel = parcelList.get(j);

                // если адрес доставки посылки (parselAddress) совпадает с адресом клиента (clientAddress), то добавляем посылку во временный список этого клиента
                if(client.getClientAddress().equals(parcel.getParcelAddress())){
                    tempParcelList.add(parcel);
                }
            }

            // создаем Map с посылками, где ключом выступает адрес клиента/доставки, а значением временный список посылок, принадлежащих одному клиенту
            postOffice.addParcel(client.getClientAddress(), tempParcelList);
        }

        // Добавляем в Map посылки с неверными адресами
        postOffice.addParcel(wrongAddress, wrongParcelList);

        // доставка посылок
        postOffice.startDeliver();

    }
}
