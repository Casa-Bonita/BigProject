package ru.study.homework.synchro.task4;

import java.io.*;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    static double [] result = new double[6];

    public static void main(String[] args) throws IOException {

// 4. В директории лежат входные текстовые файлы (необходимо их создать, не менее 5), присвоить имена по следующему шаблону: in_<N>.dat,
// где N - натуральное число. Каждый файл состоит из двух строк. В первой строке - число, обозначающее действие,
// а во второй - числа с плавающей точкой, разделенные пробелом.
// Действия могут быть следующими:
// 1 - сложение
// 2 - умножение
// 3 - сумма квадратов
// Необходимо написать многопоточное приложение, которое выполнит требуемые действия над числами и сумму результатов запишет в файл out.dat.

        CreatingSourceData csd = new CreatingSourceData();

        Runnable runnableCreate = () ->{
            synchronized (csd){
                String temp = Thread.currentThread().getName();
                String[] symbol = temp.split("\\s");
                int index = Integer.parseInt(symbol[1]);

                try{
                    csd.create(index);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        };

        for (int i = 1; i < 7; i++){
            Thread thread = new Thread(runnableCreate);
            thread.setName("Поток " + i);
            if(i == 1){
                thread.start();
            }else{
                try {
                    thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.start();
            }

        }

        ReadAndCount rac = new ReadAndCount();

        Runnable runnableReadAndCount = () ->{
            synchronized (rac){
                String temp = Thread.currentThread().getName();
                String[] symbol = temp.split("\\s");
                int index = Integer.parseInt(symbol[1]);

                try{
                    result[(index - 1)] = rac.read(index);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        };

        for (int i = 1; i < 7; i++){
            Thread thread = new Thread(runnableReadAndCount);
            thread.setName("Поток " + i);
            if(i == 1){
                thread.start();
            }else{
                try {
                    thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.start();
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println("Сумма в файле № " + i + " равняется = " + result[i]);
        }

        WriteResults wr = new WriteResults();

        Runnable runnableWriteResults = () ->{
            synchronized (wr){
                String temp = Thread.currentThread().getName();
                String[] symbol = temp.split("\\s");
                int index = Integer.parseInt(symbol[1]);

                try{
                    wr.writeresults(index, result[(index - 1)]);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        };


        for (int i = 1; i < 7; i++){
            Thread thread = new Thread(runnableWriteResults);
            thread.setName("Поток " + i);
            if(i == 1){
                thread.start();
            }else{
                try {
                    thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.start();
            }
        }

    }
}
