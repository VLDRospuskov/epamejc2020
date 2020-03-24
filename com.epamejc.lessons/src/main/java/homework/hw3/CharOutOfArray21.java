package homework.hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class CharOutOfArray21 {

    private static char[] sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            print2dArray(charOutOfArray(reader));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void print2dArray(char[][] a) {
        for (char[] arr : a) {
            for (char c : arr) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }
    }

    static char[][] charOutOfArrayCore(int nRows, int nColumns) {
        char[][] twoDimArray = new char[nRows][nColumns];

        Random sRandom = new Random();
        for (int i = 0; i < nRows; i++) {
            twoDimArray[i] = new char[nColumns];
            for (int j = 0; j < nColumns; j++) {
                twoDimArray[i][j] = sAlphabet[sRandom.nextInt(sAlphabet.length)];
            }
        }

        return twoDimArray;
    }

    static char[][] charOutOfArray(BufferedReader reader) {
        try {
            System.out.println("введите количество строк: ");
            String sRows = reader.readLine();
            int nRows = Integer.parseInt(sRows);

            System.out.println("введите количество столбцов: ");
            String sColumns = reader.readLine();
            int nColumns = Integer.parseInt(sColumns);

            return charOutOfArrayCore(nRows, nColumns);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return charOutOfArray(reader);
        } catch (NumberFormatException e) {
            System.err.println("Please input valid int number");
            return charOutOfArray(reader);
        }
    }
}
