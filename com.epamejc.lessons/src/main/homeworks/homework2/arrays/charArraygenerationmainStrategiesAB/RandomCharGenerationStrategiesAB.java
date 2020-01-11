package main.homeworks.homework2.arrays.charArraygenerationmainStrategiesAB;

import java.util.Scanner;

public class RandomCharGenerationStrategiesAB {
    private char[][] array;
    private int n;
    private int m;
    private String output = "";

    public void run() {
        inputDimension();
        createArray();
        fillArray();
        outputArray();
        inputStrategy();
    }

    private void inputDimension() {
        System.out.print("Please, enter the dimension of the array: ");
        Scanner inInt = new Scanner(System.in);
        boolean valueOk = false;
        while (!valueOk) {
            try {
                n = inInt.nextInt();
                m = inInt.nextInt();
                if (n <= 0 || m <= 0) {
                    throw new ArithmeticException();
                }
                valueOk = true;
            } catch (ArithmeticException e) {
                System.out.println("Enter a positive value.");
            } catch (Exception e) {
                System.out.println("You entered the invalid value :(");
            }
        }
    }

    private void inputStrategy() {
        Scanner inString = new Scanner(System.in);
        String strategy = "";
        boolean valueOk = false;
        System.out.print("Please, enter the strategy A or B: ");
        while (!valueOk) {
            try {
                strategy = inString.next();
                if (!strategy.equals("A") && !strategy.equals("B") && !strategy.equals("a") && !strategy.equals("b")) {
                    throw new Exception();
                }
                valueOk = true;
            } catch (Exception e) {
                System.out.println("You entered invalid value :(");
            }
        }
        if (strategy.equals("A") || strategy.equals("a")) {
            stringGenerationStrategyA();
        }
        if (strategy.equals("B") || strategy.equals("b")) {
            stringGenerationStrategyB();
        }
    }

    private void createArray() {
        array = new char[n][m];
    }

    private void fillArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = (char) (Math.random() * 26 + 97);
            }
        }
    }

    public void outputArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void stringGenerationStrategyA() {
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < m; j += 2) {
                output += String.valueOf(array[i][j]);
            }
        }
        System.out.print(output);
    }

    private void stringGenerationStrategyB() {
        for (int i = 1; i < n; i += 2) {
            for (int j = 1; j < m; j += 2) {
                output += String.valueOf(array[i][j]);
            }
        }
        System.out.print(output);
    }
}
