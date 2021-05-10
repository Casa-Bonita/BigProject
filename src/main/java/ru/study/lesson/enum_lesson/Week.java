package ru.study.lesson.enum_lesson;

import java.util.Optional;

public enum Week {
    Monday("Понедельник"), Tuesday("Вторник"), Wednsday("Среда"), Thursday("Четверг");

    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<Week> findWeekDay(String dayName){
        Week[] values = Week.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].getName().equals(dayName)){
                return Optional.ofNullable(values[i]);
            }
        }
        return Optional.empty();
    }
}
