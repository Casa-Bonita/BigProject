package ru.study.lesson.pattern.singlton;

public class Main {
    //ЦЕль паттерна запретить создание более одного объекта у класса
    //Например, есть класс подключения к базе данных. У класса может быть метод, который возвращает это подклчюени и создание нового объетка может приветси к появлению кучи подключений вместо одного

    //Создать базу данных товаров через паттер синглтон
    //У нас есть два магазина (ShopSamara, ShopMoscow) в разных городах, которые используют одну базу данных


    ShopMoscow shopMoscow = new ShopMoscow(TovarStore.getInstance());
    ShopSamara shopSamara = new ShopSamara(TovarStore.getInstance());
}
