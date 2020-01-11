package homework.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class CharOutOfArray21 {

    static char[] sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            print2dArray(charOutOfArray(reader));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void print2dArray(char[][] a) {
        for (char[] arr: a) {
            for (char c: arr) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.printf("%c ", a[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static char[][] charOutOfArray(BufferedReader reader) {

        try {
            System.out.println("введите количество строк: ");
            String srows = reader.readLine();
            int nrows = Integer.parseInt(srows);
            System.out.println("введите количество столбцов: ");
            String scolumns = reader.readLine();
            int ncolumns = Integer.parseInt(scolumns);
            char[][] twoDimArray = new char[nrows][ncolumns];

            Random sRandom = new Random();

            for (int i = 0; i < nrows; i++) {
                twoDimArray[i] = new char[ncolumns];
                for (int j = 0; j < ncolumns; j++) {
                    twoDimArray[i][j] = sAlphabet[sRandom.nextInt(sAlphabet.length)];
                }
            }

            return twoDimArray;


        } catch (IOException e) {
            System.out.println(e.getMessage());
            return charOutOfArray(reader);
        } catch (NumberFormatException e) {
            System.err.println("Please input valid int number");
            return charOutOfArray(reader);
        }
    }
}
