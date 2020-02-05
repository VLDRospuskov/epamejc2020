package main.homeworks.arrays_hw2_2.task2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CharArrayOperation {

    public void printArray(char[][] charArray) {
        for (char[] arr : charArray) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public char[][] getRandomArrayOfArrays() {
        char[][] chars = getDeclaredArrayOfArrays();
        CharArrayOperation operation = new CharArrayOperation();
        operation.fillCharsArray(chars);
        return chars;
    }

    private String[] argsInput(BufferedReader reader) {
        System.out.println("Insert rows and columns amount");
        System.out.println("For example:");
        System.out.println("5 3");
        String[] splitString = {};
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
            System.out.println("getRows function:    Wrong input. 2 numbers are needed");
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
            System.out.println("getColumns function: Wrong input. 2 numbers are needed");
        }
        return columns;
    }

    private void fillCharsArray(char[][] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[0].length; j++) {
                charArray[i][j] = (char) (Math.random() * 26 + 'a');
            }
        }
    }


    private char[][] getDeclaredArrayOfArrays() {
        int rows;
        int columns;
        char[][] charArray;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] values = argsInput(reader); // Можно ли закрыть BufferedReader в вызываемом методе, или лучше в месте создания?
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Impossible to close BufferedReader");
            e.printStackTrace();
        }
        rows = getRows(values);
        columns = getColumns(values);
        if ((rows > 0) && (columns > 0)) {
            charArray = new char[rows][columns];
            return charArray;
        } else {
            charArray = new char[0][0];
            System.out.println("If numbers are positive, read messages above");
            return charArray;
        }
    }

}
