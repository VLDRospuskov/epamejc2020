package com.epamejc.lessons.src.homework.homework5.recursion.task4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("How much Fibonacci numbers should be printed?");
            int num = getNonNegativeInteger(bufReader);
            for (int i = 0; i < num; i++) {
                System.out.print(fibonacci(i) + " ");
            }
            System.out.println("Done.");
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Non-negative value expected.");
        }
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private int getNonNegativeInteger(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                int result = Integer.parseInt(bufReader.readLine());
                if (result < 0) {
                    System.err.println("Non-negative integer required. Try again!");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Non-negative integer required. Try again!");
            }
        }
    }
}
