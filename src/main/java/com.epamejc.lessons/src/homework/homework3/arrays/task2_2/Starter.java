package com.epamejc.lessons.src.homework.homework3.arrays.task2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number of rows:");
            int rows = getNumberColumns(bufReader);
            System.out.println("Print number of columns:");
            int columns = getNumberColumns(bufReader);
            RandomArrayWrapper arr = new RandomArrayWrapper(columns, rows);
            System.out.println("Array  with random chars:");
            arr.printArray();
            System.out.println("Print output strategy \"A\" or \"B\" :");
            String strategy = getStrategyString(bufReader);
            arr.printArray(strategy);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private int getNumberColumns(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                return getPositiveInteger(bufReader);
            } catch (NumberFormatException ex) {
                System.err.println("Non-negative integer required. Try again!");
            }
        }
    }

    private Integer getPositiveInteger(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        int value = Integer.parseInt(bufReader.readLine());
        if (value < 0) {
            throw new NumberFormatException();
        }
        return value;
    }

    private String getStrategyString(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                return getStringLetter(bufReader);
            } catch (IllegalArgumentException e) {
                System.err.println("Available strategy \"A\" or \"B\" . Try again!");
            }
        }
    }

    private String getStringLetter(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        String strategy = bufReader.readLine();
        strategy = strategy.replace(" ", "");
        strategy = strategy.toUpperCase();
        if (!strategy.equals("A") && !strategy.equals("B")) {
            throw new IllegalArgumentException();
        }
        return strategy;
    }
}
