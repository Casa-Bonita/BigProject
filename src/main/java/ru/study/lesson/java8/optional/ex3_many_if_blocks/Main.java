package ru.study.lesson.java8.optional.ex3_many_if_blocks;

import ru.study.lesson.java8.optional.ex1.Tovar;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Tovar myTovar = new Tovar("tovar1");
//        Tovar myTovar = new Tovar(null);
//        Tovar myTovar = null;

//        if(myTovar!=null){
//            if(myTovar.name != null){
//                System.out.println(myTovar.name.length());
//            }
//        }


        Optional<Tovar> tovarOpt = Optional.ofNullable(myTovar);
        tovarOpt.
                map(tovar->tovar.name)
                .ifPresentOrElse(name-> System.out.println(name.length()), ()-> System.out.println("Строки name не найдено"));
    }
}
