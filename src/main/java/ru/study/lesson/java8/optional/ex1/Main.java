package ru.study.lesson.java8.optional.ex1;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //1. Создать переменную Tovar tovar. Вызывать у объекта метод print, если tovar не null. Сделать проверку через ifPresent.

        //Создадим метод, который с 50% вероятностью генерирует null или объект товара
        Optional<Tovar> tovarOpt = generateTovar();

        //Простой вариант
//       if(tovarOpt.isPresent()){
//           Tovar tovar = tovarOpt.get();
//           tovar.print();
//       }


        //Короткий вариант
//        tovarOpt.ifPresent(tovar->tovar.print()); //если товар существует, то вызовется метод print


        //Короткий вариант с else
//        tovarOpt.ifPresentOrElse(tovar->tovar.print(), ()-> System.out.println("Товар не найден"));




    }
    //Возвращаем объект в виде Optional, чтобы обработать Null
    public static Optional<Tovar> generateTovar(){
        int val = (int)(Math.random()*2);
        if(val==0){
            return Optional.ofNullable(new Tovar("tovar1"));
        }
        return Optional.empty();
    }
}
