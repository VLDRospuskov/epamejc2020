package homework.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pyramid23 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Pyramid(reader);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void Pyramid(BufferedReader reader) {
        try {
            System.out.println("введите число: ");
            String sColumns = reader.readLine();
            int nColumns = Integer.parseInt(sColumns);
            int nRows = nColumns;

            char[][]twoDimPyramid = new char[nRows][nColumns];

            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < nColumns-i; j++) {
                    twoDimPyramid[i][j] = 'x';
                    //System.out.print('X');
                }
                //System.out.println();
            }

            CharOutOfArray21.print2dArray(twoDimPyramid);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            Pyramid(reader);
        } catch (NumberFormatException e) {
            System.err.println("Please input valid int number");
            Pyramid(reader);
        }
    }
}
