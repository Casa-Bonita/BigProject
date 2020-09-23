package ru.study.lesson.interface_lesson;

public class Car extends TransportSuper implements Transport, TransportBack {


    public Car(String name) {
        super(name);
    }

    @Override
    public void goForward() {
        System.out.println("car go forward");
    }

    @Override
    public void goLeft() {

    }

    @Override
    public void goRight() {

    }

    @Override
    public void goBack() {
        System.out.println("car go back");
    }
}
