package com.epamejc.lessons.src.homework.homework5.recursion.task4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number (only integer value) :");
            int num = getInteger(bufReader);
            System.out.println("Print power (only integer value):");
            int pow = getInteger(bufReader);
            System.out.println(num + "^(" + pow + ") =" + pow(num, pow));
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }

    }

    private double pow(int number, int power) {
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            return (1 / (number * pow(number, -power - 1)));
        } else {
            return (number * pow(number, power - 1));
        }
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
