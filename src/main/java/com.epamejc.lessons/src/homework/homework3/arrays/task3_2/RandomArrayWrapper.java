package com.epamejc.lessons.src.homework.homework3.arrays.task3_2;


import com.epamejc.lessons.src.homework.homework3.arrays.task3_1.RandomArray;

public class RandomArrayWrapper extends RandomArray {
    public RandomArrayWrapper(int columns, int rows) {
        super(columns, rows);
    }

    public void printArray(String strategy) {
        switch (strategy) {
            case "A":
                printByRemainder(0);
                break;
            case "B":
                printByRemainder(1);
                break;
            default:
                super.printArray();
        }
    }

    private void printByRemainder(int remainder) {
        for (int row = 0; row < array.length; row++) {
            if (row % 2 == remainder) {
                for (int column = 0; column < array[row].length; column++) {
                    if (column % 2 == remainder) {
                        System.out.print(array[row][column] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
