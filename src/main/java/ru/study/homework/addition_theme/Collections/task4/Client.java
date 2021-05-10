package ru.study.homework.addition_theme.Collections.task4;

public class Client {
//    Создать класс Client с private полями:
//    - имя;
//    - адрес.
//    Остальную структуру Client нужно дописать по необходимости.

    private String name;
    private Address clientAddress;

    public Client() {
    }

    public Client(String name, Address clientAddress) {
        this.name = name;
        this.clientAddress = clientAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return "name = " + name + ", clientAddress = " + clientAddress;
    }

}
