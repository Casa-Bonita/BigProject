package ru.study.homework.addition_theme.Optional.task2;

import java.util.Optional;
import java.util.Random;

public class MessageGenerator {

    public static Optional<String> generateMessage(){

        Random rnd = new Random();

        int val = rnd.nextInt(2);

        String message = "";

        if(val == 0){

            for (int i = 0; i < 12; i++) {
                int temp = rnd.nextInt(6);
                switch (temp){
                    case(0):
                        message = message + "A ";
                        break;
                    case (1):
                        message = message + "B ";
                        break;
                    case (2):
                        message = message + "C ";
                        break;
                    case (3):
                        message = message + "D ";
                        break;
                    case (4):
                        message = message + "E ";
                        break;
                    case (5):
                        message = message + "F ";
                        break;
                }
            }

            message = message.trim();

            return Optional.ofNullable(message);

        }else{

            return Optional.empty();
        }

    }
}
