package homeworks.java.hw3.arrays_2;

import java.util.Scanner;

public class Strategy {

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    public String scanStrategy() {
        Scanner scan2 = new Scanner(System.in);
        String strategy = "";
        boolean badEnter = true;
        while (badEnter) {
            System.out.print("Enter strategy(A or B): ");
            try {
                strategy = scan2.nextLine();
            } catch (Exception e) {
                System.out.println("Wrong enter! " + e);
            }
            badEnter = checkStrategy(strategy);
        }

        return strategy;
    }

    public boolean checkStrategy(String strategy) {
        boolean badEnter = true;
        if (strategy.equals("A") || strategy.equals("a") || strategy.equals("B") || strategy.equals("b")) {
            badEnter = false;
        } else {
            System.out.println("Wrong enter! ");
        }
        return badEnter;
    }

    public String getStrategy(char[][] arr, String strategy) {
        String output = "";

        if (strategy.equals("A") || strategy.equals("a")) {
            output = getStrategyA(arr);
        } else if (strategy.equals("B") || strategy.equals("b")) {
            output = getStrategyB(arr);
        } else {
            System.out.println("Wrong enter!");
        }

        return output;
    }

    public String getStrategyA(char[][] arr) {
        String output = "";

        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < arr[0].length; j += 2) {
                output += arr[i][j];
            }
        }

        return output;
    }

    public String getStrategyB(char[][] arr) {
        String output = "";

        for (int i = 1; i < arr.length; i += 2) {
            for (int j = 1; j < arr[0].length; j += 2) {
                output += arr[i][j];
            }
        }

        return output;
    }
}
