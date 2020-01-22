package main.homeworks.Homework3.RandomChar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RandomCharGenerator {

    private int row, col;
    private char[][] arr;
    private BufferedReader reader;

    public void generateArr() {
        int indicator;


        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите размерность массива массиов: ");
        System.out.println("Пример: 14 2");
        if (row == 0 && col == 0) {
            do {
                indicator = reader();
            } while (indicator != 0 && indicator != 2);

            if (indicator == 2) {
                System.out.println("Error occured, sorry. Contact developer");
            }

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        getRandomArray();

    }

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
    public char[][] getArr() {
        return arr;
    }

    public RandomCharGenerator() {
        super();
    }

    public RandomCharGenerator(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    private int reader() {
        String line;
        try {
            line = reader.readLine();
            inputParser(line);
        } catch (WrongInputException ex) {
            System.out.println("Неверный ввод, повторите еще раз.");
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 2;
        }
        return 0;
    }

    private void inputParser(String str) throws WrongInputException {
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

    private void getRandomArray() {
        arr = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = (char) (Math.random() * 26 + 97);
            }
        }
    }


}
