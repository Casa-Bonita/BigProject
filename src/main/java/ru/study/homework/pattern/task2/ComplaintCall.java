package ru.study.homework.pattern.task2;

public class ComplaintCall {
    private CallCenter callCenter;

    public ComplaintCall(CallCenter callCenter){
        this.callCenter = callCenter;
    }

    public void add(Call call){
        callCenter.add(call);
    }
}

