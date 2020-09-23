package ru.study.lesson.generics.example1;

public class MainExample1 {
    public static void main(String[] args) {
        SuperContainer<Integer> sc = new SuperContainer<>();
        sc.setVal(10);
        System.out.println(sc.getVal());

        SuperContainer<String> sc2 = new SuperContainer<>();
        sc2.setVal("test");
        System.out.println(sc2.getVal());
    }
}
