package ru.study.lesson.java8.method_link.ex1;

/**
 * Функцияональный интерфейс для примера ссылок на метод
 */
public interface Calc {
    /**
     * Выполняет действие с двумя числами
     * @param a любое целое число
     * @param b любое целое число
     * @return возвращет результат действия с числами
     */
    int makeCalc(int a, int b);
}
