package ru.study.homework.addition_theme.ENUM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateFigure {

    Random rnd = new Random();
    int a, b, index;
    Rectangle rectangle = null;
    List<Rectangle> listRectangle = new ArrayList<>();

    public List<Rectangle> create(){

        for (int i = 0; i < 10; i++) {
            index = rnd.nextInt(4);
            a = rnd.nextInt(19) + 1;
            b = rnd.nextInt(9) + 1;
            switch(index) {
                case 0:
                    rectangle = new Rectangle (Color.White, a, b);
                    listRectangle.add(rectangle);
                    break;
                case 1:
                    rectangle = new Rectangle (Color.Blue, a, b);
                    listRectangle.add(rectangle);
                    break;
                case 2:
                    rectangle = new Rectangle (Color.Red, a, b);
                    listRectangle.add(rectangle);
                    break;
                case 3:
                    rectangle = new Rectangle (Color.Green, a, b);
                    listRectangle.add(rectangle);
                    break;
            }
        }

        System.out.println("\n" + "Список с 10 фигурами создан." + "\n");
        return listRectangle;
    }
}
