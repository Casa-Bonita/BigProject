package ru.study.lesson.exception.example1;

import java.io.FileNotFoundException;

//для Unchecked исключений можно унаследоваться от любого unchecked класса
public class InvalidValueException extends ArithmeticException {
    public InvalidValueException(String text){
        super(text);
    }
}
