package main.homeworks.java.homework3.arrays.task2;

import java.util.Scanner;

public class StringMaker {

    private char[][] array;

    public StringMaker(char[][] array) {
        this.array = array;
    }

    public String makeString(String strategy) {
        String result;
        switch (strategy) {
            case "A":
                result = makeStringA(array);
                break;
            case "B":
                result = makeStringB(array);
                break;
            default:
                result = "Unknown strategy";
                break;
        }
        return result;
    }

    private String makeStringA(char[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i += 2) {
            for (int j = 0; j < array[i].length; j += 2) {
                result.append(array[i][j]);
            }
        }
        return result.toString();
    }

    private String makeStringB(char[][] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < array.length; i += 2) {
            for (int j = 1; j < array[i].length; j += 2) {
                result.append(array[i][j]);
            }
        }
        return result.toString();
    }
}
