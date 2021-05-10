package ru.study.homework.addition_theme.ENUM;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//    Создать enum Color с константами: Белый, Синий, Красный, Зеленый.
//
//    Создать класс Rectangle с полями:
//    - private Color color;
//    - private int a, b.
//
//    Остальную структуру класса дополнить по необходимости.
//
//    В Main создать список List<Rectangle> и создать консольное меню:
//    1. Добавить фигуру (пользователь вводит с консоли стороны и цвет);
//    2. Вывести все фигуры определенного цвета (пользователь вводит цвет);
//    3. Проверить наличие фигуры в списке (пользователь вводит стороны фигуры и цвет. Две фигуры считаются равными, если совпадают стороны и цвет);
//    4. Выход.

        Scanner scn = new Scanner(System.in);

        Rectangle rectangle = null;

        CreateFigure cf = new CreateFigure();
        List<Rectangle> listRectangle = cf.create();


        String input = "";

        while (!input.equals("5")) {
            System.out.println("1. Печать списка всех фигур.");
            System.out.println("2. Добавить фигуру (пользователь вводит с консоли стороны и цвет).");
            System.out.println("3. Вывести все фигуры определенного цвета (пользователь вводит цвет).");
            System.out.println("4. Проверить наличие фигуры в списке (пользователь вводит стороны фигуры и цвет).");
            System.out.println("5. Выход.");

            input = scn.nextLine();

            if (input.equals("1")) {
                System.out.println("1. Печать списка всех фигур.");

                listRectangle.stream()
                        .forEach(x -> System.out.printf("%-20s %-20s %-20s %-20s %n", x.getColor(), x.getColor().getName(), x.getA(), x.getB()));

            } else if (input.equals("2")) {
                System.out.println("2. Добавить фигуру (пользователь вводит с консоли стороны и цвет).");

                System.out.println("Введите цвет фигуры:");
                String color = scn.nextLine();
                System.out.println("Введите сторону a:");
                String temp = scn.nextLine();
                int a = Integer.parseInt(temp);
                System.out.println("Введите сторону b:");
                temp = scn.nextLine();
                int b = Integer.parseInt(temp);

                Optional<Color> colorOptional = Color.findColor(color);
//                if(colorOptional.isPresent()){
//                    if(a > 0 && b > 0 ){
//                        rectangle = new Rectangle (colorOptional.get(), a, b);
//                        listRectangle.add(rectangle);
//                        System.out.println("Фигура добавлена");
//                    }
//                    else {
//                        System.out.println("Стороны должны быть больше \"0\"");
//                    }
//                }
//                else{
//                    System.out.println("Данный цвет отсутствует в списке.");
//                }

                colorOptional.ifPresentOrElse(
                        clr -> {
                            if (a > 0 && b > 0) {
                                listRectangle.add(new Rectangle(clr, a, b));
                                System.out.println("Фигура добавлена");
                            }
                        },
                        () -> {
                            System.out.println("Данный цвет отсутствует в списке.");
                        });

            } else if (input.equals("3")) {
                System.out.println("3. Вывести все фигуры определенного цвета (пользователь вводит цвет).");

                System.out.println("Введите цвет фигуры:");
                String color = scn.nextLine();

                Optional<Color> colorOptional = Color.findColor(color);
                if (colorOptional.isPresent()) {
                    for (int i = 0; i < listRectangle.size(); i++) {
                        rectangle = listRectangle.get(i);
                        if (colorOptional.get().equals(rectangle.getColor())) {
                            System.out.printf("%-20s %-20s %-20s %-20s %n", rectangle.getColor(), rectangle.getColor().getName(), rectangle.getA(), rectangle.getB());
                        }
                    }
                }
            } else if (input.equals("4")) {
                System.out.println("4. Проверить наличие фигуры в списке (пользователь вводит стороны фигуры и цвет).");

                System.out.println("Введите цвет фигуры:");
                String color = scn.nextLine();
                System.out.println("Введите сторону a:");
                String temp = scn.nextLine();
                int a = Integer.parseInt(temp);
                System.out.println("Введите сторону b:");
                temp = scn.nextLine();
                int b = Integer.parseInt(temp);

                Optional<Color> colorOptional = Color.findColor(color);
                boolean isExist = false;
                if (colorOptional.isPresent()) {
                    for (int i = 0; i < listRectangle.size(); i++) {
                        rectangle = listRectangle.get(i);
                        if (colorOptional.get().equals(rectangle.getColor()) && a == rectangle.getA() && b == rectangle.getB()) {
                            System.out.printf("%-20s %-20s %-20s %-20s %n", rectangle.getColor(), rectangle.getColor().getName(), rectangle.getA(), rectangle.getB());
                            isExist = true;

                        }
                    }
                }
                if(!isExist){
                    System.out.println("Фигура отсутствует");
                }
            } else if (input.equals("5")) {
                System.out.println("5. Выход.");
            } else {
                System.out.println("6. Некорректный ввод.");
            }

        }


    }
}
