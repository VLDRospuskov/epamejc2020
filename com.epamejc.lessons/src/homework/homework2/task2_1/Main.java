package homework.homework2.task2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        int columns;
        int rows;
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print number of rows:");
            rows = getPositiveInteger(bufReader);
            System.out.println("Print number of columns:");
            columns = getPositiveInteger(bufReader);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
            return;
        }
        RandomArray arr = new RandomArray(columns, rows);
        System.out.println("Array  with random chars:");
        arr.printArray();
    }

    int getPositiveInteger(BufferedReader bufReader) throws IOException, IllegalArgumentException {
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

}

