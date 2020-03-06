package main.homeworks.homework3.charArraygenerationmainStrategiesAB;

import java.util.Scanner;

public class RandomCharGenerationStrategiesAB {

    private char[][] array;
    private int n;
    private int m;
    private String output = "";

    public void setArray(char[][] array) {
        this.array = array;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public char[][] getArray() {
        return array;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public String getOutput() {
        return output;
    }

    public void run() {
        inputDimension();
        fillArray();
        outputArray();
        inputStrategy();
    }

    public void inputDimension() {
        System.out.print("Please, enter the dimension of the array: ");
        boolean valueOk = false;
        while (!valueOk) {
            try {
                Scanner inInt = new Scanner(System.in);
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

    public void inputStrategy() {
        Scanner sc = new Scanner(System.in);
        String strategy = "";
        boolean valueOk = false;
        System.out.print("Please, enter the strategy A or B: ");
        while (!valueOk) {
            try {
                strategy = sc.next();
                if (!strategy.equals("A") && !strategy.equals("B") && !strategy.equals("a") && !strategy.equals("b")) {
                    throw new Exception();
                }
                valueOk = true;
                sc.close();
            } catch (Exception e) {
                System.out.println("You entered invalid value :(");
            }
        }
        sc.close();
        whichStrategy(strategy);
    }

    public void fillArray() {
        array = new char[n][m];
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

    public void whichStrategy(String strategy) {
        if (strategy.equals("A") || strategy.equals("a")) {
            stringGenerationStrategyA();
        }
        if (strategy.equals("B") || strategy.equals("b")) {
            stringGenerationStrategyB();
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
