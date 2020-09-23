package ru.study.homework.synchro.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ReadAndCount {
    Charset win1251 = Charset.forName("Windows-1251");
//    ArrayList<> list = new ArrrayList<>();

    public double read(int index) throws IOException{

        String pathFile = "src/ru/study/homework/synchro/task4/in_" + index + ".dat";
        System.out.println("Чтение файла № " + index);
        System.out.println(pathFile + "\n");

        FileInputStream fis = null;
        try{
            fis = new FileInputStream(pathFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(fis, win1251);
        BufferedReader br = new BufferedReader(isr);

        String str = br.readLine();
        int operationType = Integer.parseInt(str);
//        list.add(operationType);
        str = br.readLine();
        String[] dataString = str.split("\\s");
        double [] data = new double [dataString.length];
        for (int i = 0; i < dataString.length; i++) {
            data[i] = Double.parseDouble(dataString[i]);
//            list.add(data[i]);
        }
        br.close();

        if(operationType == 1){
            double resultSum = 0.0;
            for (int i = 0; i < data.length; i++) {
                resultSum = resultSum + data[i];
            }
            return resultSum;

        }else if(operationType == 2){
            double resultMult = 1.0;
            for (int i = 0; i < data.length; i++) {
                resultMult = resultMult * data[i];
            }
            return resultMult;

        }else{
            double resultSquareSum = 0.0;
            for (int i = 0; i < data.length; i++) {
                resultSquareSum = resultSquareSum + data[i] * data[i];
            }
            return resultSquareSum;
        }

    }
}
