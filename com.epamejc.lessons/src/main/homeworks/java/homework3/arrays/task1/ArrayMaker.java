package main.homeworks.java.homework3.arrays.task1;

import java.util.Random;

public class ArrayMaker {

    public char[][] makeArray(int a, int b) {
        char[][] result = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                result[i][j] = getRandomChar();
            }
        }
        return result;
    }

    public void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char getRandomChar() {
        Random rand = new Random();
        char c = (char) (rand.nextInt(26) + 'a');
        return c;
    }


}
