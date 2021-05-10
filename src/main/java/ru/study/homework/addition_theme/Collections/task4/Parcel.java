package ru.study.homework.addition_theme.Collections.task4;

public class Parcel {
//    Создать класс Parcel (посылка) с private полями:
//    - название содержимого посылки;
//    - адрес получателя.
//    Остальную структуру Parcel нужно дописать по необходимости.

    private String parcelContent;
    private Address parcelAddress;

    public Parcel() {
    }

    public Parcel(String parcelContent, Address parcelAddress) {
        this.parcelContent = parcelContent;
        this.parcelAddress = parcelAddress;
    }

    public String getParcelContent() {
        return parcelContent;
    }

    public void setParcelContent(String parcelContent) {
        this.parcelContent = parcelContent;
    }

    public Address getParcelAddress() {
        return parcelAddress;
    }

    public void setParcelAddress(Address parcelAddress) {
        this.parcelAddress = parcelAddress;
    }

    @Override
    public String toString() {
        return "parcelContent = " + parcelContent + ", parcelAddress = " + parcelAddress;
    }
}
