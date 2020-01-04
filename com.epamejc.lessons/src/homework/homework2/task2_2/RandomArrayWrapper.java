package homework.homework2.task2_2;

import homework.homework2.task2_1.RandomArray;

public class RandomArrayWrapper extends RandomArray {
    public RandomArrayWrapper(int columns, int rows) {
        super(columns, rows);
    }

    public void printArray(String strategy) {
        switch (strategy) {
            case "A":
                for (int row = 0; row < array.length; row++) {
                    if (row % 2 == 0) {
                        for (int column = 0; column < array[row].length; column++) {
                            if (column % 2 == 0) {
                                System.out.print(array[row][column] + " ");
                            }
                        }
                        System.out.println();
                    }
                }
                break;
            case "B":
                for (int row = 0; row < array.length; row++) {
                    if (row % 2 != 0) {
                        for (int column = 0; column < array[row].length; column++) {
                            if (column % 2 != 0) {
                                System.out.print(array[row][column] + " ");
                            }
                        }
                        System.out.println();
                    }
                }
                break;
            default:
                super.printArray();
        }
    }
}
