package ru.study.lesson.java8.optional.ex2_postmail;

import java.util.Optional;

public class ParcelGenerator {
    public static Optional<Parcel> generateParcel(){
        int val = (int)(Math.random()*2);
        if(val==0){
            return Optional.ofNullable(new Parcel("parcel1"));
        }
        return Optional.empty();
    }
}
