package ru.study.homework.rosalind.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C://Users//Home//Downloads/rosalind_dna.txt"));

        String str = br.readLine();
        String [] arrString = str.split("");

        int countA = 0;
        int countG = 0;
        int countC = 0;
        int countT = 0;

        for (int i = 0; i < arrString.length; i++) {
            if(arrString[i].equals("A")){
                countA++;

            }else if(arrString[i].equals("G")){
                countG++;

            }else if(arrString[i].equals("C")){
                countC++;

            }else {
                countT++;

            }
        }
        System.out.println(countA + " " + countC + " " + countG + " " + countT);
    }
}
