package homeworks.java.hw3.arrays_2;

import java.util.*;

public class StringGeneratorFromArrayByStrategy {

    public void run() {
        int[] numbers = scanNumbers();
        String output = getStrategy(numbers, buildArray(numbers), scanStrategy());
        System.out.println("Result: " + output);
    }

    public int[] scanNumbers() {
        Scanner sc = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;

        try {
            System.out.print("Enter the number of lines: ");
            n1 = sc.nextInt();
            System.out.print("Enter the number of characters: ");
            n2 = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }

        int[] numbers  = new int[] {n1, n2};

        return numbers;
    }

    public String scanStrategy() {
        Scanner scan2 = new Scanner(System.in);
        String strategy = "";

        try {
            System.out.print("Enter strategy(A or B): ");
            strategy = scan2.nextLine();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
            System.exit(0);
        } finally {
            scan2.close();
        }

        return strategy;
    }

    public char[][] buildArray(int[] numbers) {
        char[][] arr = new char[numbers[0]][numbers[1]];
        Random r = new Random();

        for (int i = 0; i < numbers[0]; i++) {
            for (int j = 0; j < numbers[1]; j++) {
                arr[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

        return arr;
    }

    public String getStrategy(int[] numbers, char[][] arr, String strategy) {
        String output = "";

        if (strategy.equals("A") || strategy.equals("a")) {
            for (int i = 0; i < numbers[0]; i += 2) {
                for (int j = 0; j < numbers[1]; j += 2) {
                    output += arr[i][j];
                }
            }
        } else if (strategy.equals("B") || strategy.equals("b")) {
            for (int i = 1; i < numbers[0]; i += 2) {
                for (int j = 1; j < numbers[1]; j += 2) {
                    output += arr[i][j];
                }
            }
        } else {
            System.out.println("Wrong enter!");
        }

        return output;
    }

}
