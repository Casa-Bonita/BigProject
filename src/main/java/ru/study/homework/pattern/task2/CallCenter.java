package ru.study.homework.pattern.task2;

import java.util.*;

public class CallCenter {
    private List<Call> callList;
    private static CallCenter callCenter;

    public CallCenter(){
        callList = new ArrayList<>();
    }

    public static CallCenter getInstance(){
        if(callCenter == null){
            callCenter = new CallCenter();
        }
        return callCenter;
    }

    public void add(Call call){
        callList.add(call);
    }

    public Call get(int index){
        return callList.get(index);
    }
}