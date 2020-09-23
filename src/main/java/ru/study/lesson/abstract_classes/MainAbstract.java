package ru.study.lesson.abstract_classes;

import java.util.ArrayList;
import java.util.List;

public class MainAbstract {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList();
        list.add(new Rectangle("Периметр1"));
        list.add(new Triangle("Треугольник1"));
        for(Shape sh: list){
            System.out.println(sh.getSquare());
        }

//        Rectangle rec = new Rectangle("Треуг 2"){
//            @Override
//            public int getSquare() {
//                return -1;
//            }
//        };
//
//        Rectangle rec2 = new Rectangle("Треуг 3"){
//            @Override
//            public int getSquare() {
//                return -1;
//            }
//        };
//
//        System.out.println(rec.getSquare());


        Shape shape = new Shape("Круг") {
            @Override
            public int getSquare() {
                return (int)(2 * Math.PI * 10);
            }

            @Override
            public int getPerimetr() {
                return (int)(2*Math.PI*10);
            }
        };
        System.out.println(shape.getSquare());
        System.out.println(shape.name);
    }
}
