package ru.study.homework.multithreading.task4;

import java.io.*;
import java.nio.charset.Charset;


public class MyThread implements Runnable {

    String pathFile = "src/ru/study/homework/multithreading/task4/data.csv";
    Charset win1251 = Charset.forName("Windows-1251");




    public void run(){
        BufferedWriter bw  = null;
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos, win1251);
            bw = new BufferedWriter(osw);
            double res = 1.0;
            for (int i = 2; i < 11; i++) {
                res = res * (i + 1) / (i - 1);
                Thread.sleep(2000);
                bw.write(String.valueOf(res));
                bw.write(";");
                bw.newLine();
            }
        }catch (Exception e){}
        finally {
            try {
                bw.close();
            }catch (Exception e){}
        }
        System.out.println("Запись завершена");

    }
}
