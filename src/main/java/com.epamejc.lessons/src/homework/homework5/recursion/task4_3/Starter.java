package com.epamejc.lessons.src.homework.homework5.recursion.task4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number (only integer value) :");
            int num = getInteger(bufReader);
            System.out.println("Number of digits: " + numOfDigits(num));
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }

    }

    private int numOfDigits(int number) {
        int newNum = number / 10;
        return newNum != 0 ? 1 + numOfDigits(newNum) : 1;
    }

    private int getInteger(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                return Integer.parseInt(bufReader.readLine());
            } catch (NumberFormatException ex) {
                System.err.println("Integer value required. Try again!");
            }
        }
    }
}
