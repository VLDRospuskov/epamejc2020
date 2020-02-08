package main.java.homework4.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormatString {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() {
        System.out.println("Enter some string and \"even\" or \"odd\". " + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Please enter the string:");
                String startString = reader.readLine();
                if (!startString.equals("exit")) {
                    evenOrOdd(startString);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void evenOrOdd(String startString) {
        try {
            while (true) {
                System.out.println("Please enter \"even\", \"odd\":");
                String evenOdd = reader.readLine();

                if (evenOdd.equals("even")) {
                    formatEvenString(startString);
                    break;
                } else if (evenOdd.equals("odd")) {
                    formatOddString(startString);
                    break;
                } else if (evenOdd.equals("exit")) {
                    System.exit(0);
                    reader.close();
                } else {
                    System.out.println("Incorrect input.Try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void formatEvenString(String startString) {
        String result = "";
        for (int i = 1; i < startString.length(); i = i + 2) {
            result += startString.charAt(i);
        }
        System.out.println(result);
    }

    private void formatOddString(String startString) {
        String result = "";
        for (int i = 0; i < startString.length(); i = i + 2) {
            result += startString.charAt(i);
        }
        System.out.println(result);
    }
}
