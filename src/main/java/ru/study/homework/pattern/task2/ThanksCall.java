package ru.study.homework.pattern.task2;

public class ThanksCall {
    private CallCenter callCenter;

    public ThanksCall(CallCenter callCenter){
        this.callCenter = callCenter;
    }

    public void add(Call call){
        callCenter.add(call);
    }
}