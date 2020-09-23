package ru.study.homework.multithreading.task1;

public class MyReaderWriterService{
    static void startRead(MyReader reader, String filepath){
        reader.read(filepath);
    }

    static void startWrite(MyWriter writer, String filepath){
        writer.write(filepath);
    }


}
