package ru.study.homework.rosalind.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C://Users//Home//Downloads/rosalind_rna.txt"));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

//        String str = "GATGGAACTTGACTACGTAAATT";
        String [] arrString = str.split("");

        String newStr = "";

        for (int i = 0; i < arrString.length; i++) {
            if(arrString[i].equals("T")){
                arrString[i] = "U";

            }
        }

        for (int i = 0; i < arrString.length; i++) {
            sb.append(arrString[i]);

        }
        System.out.println(str);
        System.out.println(sb);
    }
}
