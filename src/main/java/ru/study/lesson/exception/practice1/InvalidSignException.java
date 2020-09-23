package ru.study.lesson.exception.practice1;

public class InvalidSignException extends Exception {
//    String line ;
    public InvalidSignException(String line){
        super("InvalidSignException: знак "+line+" не известен");
        //this.line = line;
    }

//    @Override
//    public String toString() {
//        return getClass().getName()+ ": знак "+line+" не известен";
//    }
}
