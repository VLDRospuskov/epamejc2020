package main.lesson3.task2_Arrays.task2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CharArrayOperation {

    private String[] argsInput(String[] splitString) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert rows and columns amount");
        System.out.println("For example:");
        System.out.println("5 3");
        try {
            splitString = reader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return splitString;
    }

    private int getRows(String[] stringToParse) {
        int rows = 0;
        if (stringToParse.length == 2) {
            try {
                rows = Integer.parseInt(stringToParse[0]);
            } catch (NumberFormatException e) {
                System.out.println("Rows number is wrong");
            }
        } else {
            System.out.println("Wrong input");
        }
        return rows;
    }

    private int getColumns(String[] stringToParse) {
        int columns = 0;
        if (stringToParse.length == 2) {
            try {
                columns = Integer.parseInt(stringToParse[1]);
            } catch (NumberFormatException e) {
                System.out.println("Columns number is wrong");
            }
        } else {
            System.out.println("Wrong input");
        }
        return columns;
    }

    private void fillCharsArray(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j] = (char) (Math.random() * 26 + 'a');
            }
        }
    }

    private void printArray(char[][] chars) {
        for (char[] arr : chars) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void createArrayOfArrays() {
        int rows = 0;
        int columns = 0;
        char[][] chars;
        String[] values = {};
        values = argsInput(values);
        rows = getRows(values);
        columns = getColumns(values);
        if ((rows > 0) && (columns > 0)) {
            chars = new char[rows][columns];
            CharArrayOperation operation = new CharArrayOperation();
            operation.fillCharsArray(chars);
            operation.printArray(chars);
        } else {
            System.out.println("It must be positive numbers");
        }
    }
}
