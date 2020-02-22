package homeworks.homework3;

import java.util.Random;

public class MultipleArrayBuilder {

    public char[][] createArray(int line, int column) {
        char[][] arr = new char[line][column];
        Random rnd = new Random();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) (97 + rnd.nextInt(122 - 97));
            }
        }

        return arr;
    }

    public String printArray(char[][] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                str += arr[i][j] + " ";
            }

            str += "\n";
        }

        return str;
    }

    public String printEven(char[][] arr) {
        String str = "";

        for (int i = 1; i < arr.length; i += 2) {
            for (int j = 1; j < arr[i].length; j += 2) {
                str += arr[i][j];
            }
        }

        return str;
    }

    public String printOdd(char[][] arr) {
        String str = "";

        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr[i].length; j += 2) {
                str += arr[i][j];
            }
        }

        return str;
    }

    public String pyramid(int n) {
        int[][] twoDimArray = new int[n][];
        String str = "";

        for (int i = 0; i < n; i++) {
            twoDimArray[i] = new int[n - i];
        }

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                str += twoDimArray[i][j];
            }
            str += "\n";
        }

        return str;
    }

}
