package ru.study.lesson.enum_lesson;

public class WeekPlan {
    Week weekDay;
    String text; //планы на день недели weekDay

    public WeekPlan(Week weekDay, String text) {
        this.weekDay = weekDay;
        this.text = text;
    }

    @Override
    public String toString() {
        return "WeekPlan{" +
                "weekDay=" + weekDay +
                ", text='" + text + '\'' +
                '}';
    }
}
