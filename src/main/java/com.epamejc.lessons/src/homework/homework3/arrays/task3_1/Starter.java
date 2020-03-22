package com.epamejc.lessons.src.homework.homework3.arrays.task3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {

    public void start() {
        int columns;
        int rows;
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number of rows:");
            rows = getPositiveNumber(bufReader);
            System.out.println("Print number of columns:");
            columns = getPositiveNumber(bufReader);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
            return;
        }
        RandomArray arr = new RandomArray(columns, rows);
        System.out.println("Array  with random chars:");
        arr.printArray();
    }

    private int getPositiveNumber(BufferedReader bufReader) throws IOException, IllegalArgumentException {
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
}
