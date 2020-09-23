package ru.study.lesson.interface_lesson;

public class Plane extends TransportSuper implements Transport {
    public Plane(String name) {
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
}
