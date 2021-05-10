package ru.study.homework.addition_theme.Collections.task1;

import java.util.Optional;
import java.util.Random;

public class Create {

    int a;
    String element;

    public Optional<String> create(){

        Random rnd = new Random();

        int val = rnd.nextInt(2);

        if(val == 0) {
            a = (rnd.nextInt(199) + 1) * (rnd.nextInt(99) + 1);
            element = String.valueOf(a);
            return Optional.ofNullable(element);
        }
        else{
            return Optional.empty();
        }

    }
}
