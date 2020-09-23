package ru.study.lesson.interface_lesson;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TransportSuper> list = Arrays.asList(new Car("BMW"), new Plane("Plane1"));
        for(TransportSuper t : list){
            Transport tr = (Transport)t;
            tr.goForward();
            if(t instanceof TransportBack){
                TransportBack tb = (TransportBack)t;
                tb.goBack();
            }
        }

    }
}
