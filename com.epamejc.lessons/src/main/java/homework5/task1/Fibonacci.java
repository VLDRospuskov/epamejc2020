package main.java.homework5.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() {
        System.out.println("Enter the element number of the Fibonacci row" + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String fibString = reader.readLine();
                if (!fibString.equals("exit")) {
                    inputCheck(fibString);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void inputCheck(String fibString) {
        while (true) {
            try {
                int fib = Integer.parseInt(fibString);
                if (fib <= 45) {
                    System.out.println(findFib(fib));
                } else {
                    System.out.println("Entered too big number. Please enter number less than or equal 45.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.Try again.");
            }
        }
    }

    private int findFib(int fib) {
        if (fib == 0) {
            return 0;
        }
        if (fib == 1) {
            return 1;
        }
        return findFib(fib - 1) + findFib(fib - 2);
    }
}
