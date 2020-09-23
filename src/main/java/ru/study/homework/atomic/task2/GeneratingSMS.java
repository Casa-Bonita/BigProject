package ru.study.homework.atomic.task2;

import java.util.*;

public class GeneratingSMS {
    private int a;
    private String sms = "";

    Random rnd = new Random();

    public String generate(){
        for (int i = 0; i < 4; i++) {
            a = rnd.nextInt(9);
            String temp = Integer.toString(a);
            sms = sms + temp;
        }
        return sms;
    }

}
