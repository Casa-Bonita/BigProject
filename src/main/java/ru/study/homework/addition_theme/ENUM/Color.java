package ru.study.homework.addition_theme.ENUM;

import java.util.Optional;

public enum Color {
    White("Белый"),
    Blue("Синий"),
    Red("Красный"),
    Green("Зелёный");

    private String name;

    Color() {
    }

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<Color> findColor(String color){
        for(Color clr : Color.values()) {
            if(clr.name().equalsIgnoreCase(color) || clr.getName().equalsIgnoreCase(color)){
                return Optional.ofNullable(clr);
            }
        }
        System.out.println("Данный цвет отсутствует в списке.");
        return Optional.empty();
    }
}
