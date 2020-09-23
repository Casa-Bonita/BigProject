package ru.study.homework.synchro.task4;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Random;

public class CreatingSourceData {
    Random rnd = new Random();
    Charset win1251 = Charset.forName("Windows-1251");

    public void create(int index) throws IOException{

        String pathFile = "src/ru/study/homework/synchro/task4/in_" + index + ".dat";
        System.out.println("Создание файла № " + index);
        System.out.println(pathFile + "\n");

        String number = "";
        double a = 0.0;
        for (int j = 0; j < 10; j++) {
            a = rnd.nextDouble() + rnd.nextInt(30);
            a = (double) Math.round(a * 100) / 100;

            if(j != 9){
                number = number + String.valueOf(a) + " ";
            }else{
                number = number + String.valueOf(a);
            }
        }

        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(pathFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        OutputStreamWriter osw = new OutputStreamWriter(fos, win1251);
        BufferedWriter bw = new BufferedWriter(osw);

        if(index == 1 || index == 2){
            bw.write("1");
        }else if(index == 3 || index == 4){
            bw.write("2");
        }else{
            bw.write("3");
        }

        bw.write("\n");
        bw.write(number);
        bw.close();

    }
}
