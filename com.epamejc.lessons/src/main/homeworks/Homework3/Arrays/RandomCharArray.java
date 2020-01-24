package main.homeworks.Homework3.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class RandomCharArray {

    private int row, col;
    private char[][] arr;

    public void generateArr(BufferedReader reader) {
        int indicator;

        System.out.println("Введите размерность массива массиов: ");
        System.out.println("Пример: 14 2");
        if (row == 0 && col == 0) {
            do {
                indicator = readInput(reader);
            } while (indicator != 0 && indicator != 2);

            if (indicator == 2) {
                System.out.println("Error occurred, sorry. Contact developer");
            }
        }
        fillArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomCharArray that = (RandomCharArray) o;
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
            for (int i = 0; i < arr.length; i += 2) {
                for (int j = 0; j < arr[i].length; j += 2) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        } else if (strategy == Strategy.B) {
            for (int i = 1; i < arr.length; i += 2) {
                for (int j = 1; j < arr[i].length; j += 2) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }

    public char[][] getArr() {
        return arr;
    }

    public RandomCharArray() {
        super();
    }

    public RandomCharArray(int row, int col) {
        this.row = row;
        this.col = col;
    }

    private int readInput(BufferedReader reader) {
        String line;
        try {
            line = reader.readLine();
            parseInput(line);
        } catch (WrongInputException ex) {
            System.out.println("Неверный ввод, повторите еще раз.");
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 2;
        }
        return 0;
    }

    private void parseInput(String str) throws WrongInputException {
        String[] temp = ((str.replaceAll("\\D+", " ").trim()).split(" "));
        int[] result = new int[temp.length];

        if (temp.length != 2) {
            throw new WrongInputException("Wrong input");
        }
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.valueOf(temp[i]);
        }

        row = result[0];
        col = result[1];
    }

    private void fillArray() {
        arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (char) (Math.random() * 26 + 97);
            }
        }
    }


}
