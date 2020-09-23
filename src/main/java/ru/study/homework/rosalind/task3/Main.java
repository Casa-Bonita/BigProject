package ru.study.homework.rosalind.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C://Users//Home//Downloads/rosalind_revc.txt"));
        String str = br.readLine();

        String [] arrStr = str.split("");
        String [] arrStrReverce = new String[arrStr.length];

        for (int i = 0; i < arrStr.length; i++) {
            int k = arrStr.length - 1;
            if(arrStr[i].equals("A")){
                arrStrReverce[k - i] = "T";

            }else if(arrStr[i].equals("C")){
                arrStrReverce[k - i] = "G";

            }else if(arrStr[i].equals("G")){
                arrStrReverce[k - i] = "C";

            }else {
                arrStrReverce[k - i] = "A";
            }
        }

        for (int i = 0; i < arrStrReverce.length; i++) {
            System.out.print(arrStrReverce[i]);
        }
    }
}
