package src.homeworks.hw4;

import java.util.Scanner;

public class EvenOdd {

    public static void getEvenOddSymbols(String inputString) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose even or odd symbols: ");
        String strategyString = "";
        String result = "";

        while (!strategyString.equalsIgnoreCase("even") && !strategyString.equalsIgnoreCase("odd")) {
            strategyString = in.nextLine();
            switch (strategyString.toLowerCase()) {
                case ("odd"):
                    for (int i = 0; i < inputString.length(); i += 2) {
                        result += inputString.charAt(i);
                    }
                    break;
                case ("even"):
                    for (int i = 1; i < inputString.length(); i += 2) {
                        result += inputString.charAt(i);
                    }
                    break;
                default:
                    System.out.println("Type 'even' or 'odd' ");
                    break;
            }
        }

        System.out.println(result);

    }

}
