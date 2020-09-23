package ru.study.homework.synchro.task4;

import java.io.*;
import java.nio.charset.Charset;

public class WriteResults {
    Charset win1251 = Charset.forName("Windows-1251");

    public void writeresults(int index, double result) throws IOException{

        System.out.println("\n" + "Запись файла out.dat");
        String pathFile = "src/ru/study/homework/synchro/task4/out.dat";

//        FileOutputStream fos = null;
//        try{
//            fos = new FileOutputStream(pathFile);
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }
//
//        OutputStreamWriter osw = new OutputStreamWriter(fos, win1251);
//        BufferedWriter bw = new BufferedWriter(osw);


        FileWriter fw = new FileWriter(pathFile, true);

        String line = index + " = " + result;
        System.out.println("Записывается строка: " + line);

        if(index == 1){
//            bw.write(line);
            fw.write(line + "\n");

        }

        else if (index == 2){
//            bw.newLine();
//            bw.write(line);
            fw.write(line + "\n");
        }

        else if (index == 3){
//            bw.newLine();
//            bw.newLine();
//            bw.write(line);
        fw.write(line + "\n");
        }

        else if (index == 4){
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.write(line);
        fw.write(line + "\n");
        }

        else if (index == 5) {
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.write(line);
        fw.write(line + "\n");
        }

        else{
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.newLine();
//            bw.write(line);
        fw.write(line + "\n");
        }

//        bw.close();

        fw.close();



    }
}

