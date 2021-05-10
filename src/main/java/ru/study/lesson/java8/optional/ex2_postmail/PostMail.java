package ru.study.lesson.java8.optional.ex2_postmail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostMail {
    private List<Parcel> parcelList = new ArrayList<>();

    public void addParcel(Parcel parcel){
        parcelList.add(parcel);
    }

    public void makeSend(){
        for (int i = 0; i < parcelList.size(); i++) {
            System.out.println("Посылка "+parcelList.get(i).name +" отправлена!");
        }
    }
}
