package ru.study.lesson.io.example3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Конвертация из байтовых потоков в символьные
        String pathFile = "src/ru/study/lesson/io/example3/text.txt";


        FileOutputStream fos = new FileOutputStream(pathFile);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        //три операции в одной
        //BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFile)));

        bw.write("hello world");
        bw.newLine();
        bw.close();

        FileInputStream fis = new FileInputStream(pathFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        System.out.println(br.readLine());
        br.close();
    }
}
