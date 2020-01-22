package main.homeworks.Homework3.RandomCharToString;

import java.util.Arrays;

public class RandomCharGenerator {

    private int row, col;
    private char[][] arr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomCharGenerator that = (RandomCharGenerator) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    public void print() {
        System.out.println("Массив " + row + " на " + col + ": ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void print(Strategy strategy) {
        if (strategy == Strategy.A) {
            for (int i = 0; i < arr.length; i+=2) {
                for (int j = 0; j < arr[i].length; j+=2) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        } else if(strategy == Strategy.B) {
            for (int i = 1; i < arr.length; i+=2) {
                for (int j = 1; j < arr[i].length; j+=2) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }

    public char[][] getArr() {
        return arr;
    }

    public RandomCharGenerator(int row, int col) {
        this.row = row;
        this.col = col;

        getRandomArray();
    }

    private void getRandomArray() {
        arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (char) (Math.random() * 26 + 97);
            }
        }
    }


}
