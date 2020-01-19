package main.HW2.Number3_2;

import java.io.*;

/*Написать программу которая будет генерировать строку по индексам.*/

public class main {
    public static void main(String[] args) {

        BufferedReader readerOfString = new BufferedReader( new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.println("Write your sentence: ");
            str = readerOfString.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String ind = null;
        try {
            System.out.println("Write index: ");
            ind = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = Integer.parseInt(ind);

        char[] strToChar = str.toCharArray();

        System.out.println("Result: ");
        System.out.println(strToChar[index]);

    }
}
