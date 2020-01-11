package homework.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrategyAB22 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            choosingStrategy(reader);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void choosingStrategy(BufferedReader reader) {
        char a[][] = CharOutOfArray21.charOutOfArray(reader);
        CharOutOfArray21.print2dArray(a);
        try {
            System.out.println("Input Strategy: ");
            String sStrategy = reader.readLine();
            switch (sStrategy) {
                case "A":
                    StrategyA(a);
                    break;
                case "B":
                    StrategyB(a);
                    break;
                default:
                    System.out.println("please choose A or B strategy");
                    choosingStrategy(reader);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void StrategyA(char[][] a) {
        for (int i = 0; i < a.length; i += 2) {
            for (int j = 0; j < a[i].length; j += 2) {
                System.out.print(a[i][j]);
            }
        }
    }

    public static void StrategyB(char[][] a) {
        for (int i = 1; i < a.length; i += 2) {
            for (int j = 1; j < a[i].length; j += 2) {
                System.out.print(a[i][j]);
            }
        }
    }
}