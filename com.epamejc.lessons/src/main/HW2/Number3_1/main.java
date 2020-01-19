package main.HW2.Number3_1;

/*Написать программу которая генерирует новую строку на основании входных данных,
 строка + четные/нечетные*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {

        String strOdd = "2";

        BufferedReader readerOfString = new BufferedReader( new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.println("Write your sentence: ");
            str = readerOfString.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String method = null;
        try {
            System.out.println("Write strategy even or odd (choose 1 or 2): ");
            method = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] strToChar = str.toCharArray();
        //Odd
        if(method.equals(strOdd)) {
            for (int i = 0; i < strToChar.length; i++) {
                if (i % 2 == 0) {
                    System.out.print(strToChar[i]);
                }
            }
        }else {
            //Even
            for (int i = 0; i < strToChar.length; i++) {
                if (i % 2 != 0) {
                    System.out.print(strToChar[i]);
                }
            }
        }
    }
}
