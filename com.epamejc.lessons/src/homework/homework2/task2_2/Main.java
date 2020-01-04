package homework.homework2.task2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number of rows:");
            int rows = getPositiveInteger(bufReader);
            System.out.println("Print number of columns:");
            int columns = getPositiveInteger(bufReader);
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

    private int getPositiveInteger(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            try {
                int value = Integer.parseInt(bufReader.readLine());
                if (value < 0) {
                    System.err.println("Non-negative integer required. Try again!");
                } else {
                    return value;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Non-negative integer required. Try again!");
            }
        }
    }

    private String getStrategyString(BufferedReader bufReader) throws IOException, IllegalArgumentException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String strategy = bufReader.readLine();
            strategy = strategy.replace(" ", "");
            strategy = strategy.toUpperCase();
            if (!strategy.equals("A") && !strategy.equals("B")) {
                System.err.println("Available strategy \"A\" or \"B\" . Try again!");
            } else {
                return strategy;
            }
        }
    }

}

