package com.epamejc.lessons.src.homework.homework3.arrays.task2_1;

import java.util.Random;

public class RandomArray {
    private final Random rand = new Random();
    protected char[][] array;

    public RandomArray(int columns, int rows) {
        if (columns < 0 || rows < 0) throw new IllegalArgumentException("Non-negative values required!");
        array = new char[rows][columns];
        fillArrayByRandomChars();
    }

    private void fillArrayByRandomChars() {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                array[row][column] = (char) ('a' + rand.nextInt(26));
            }
        }

    }

    public void printArray() {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }
}
