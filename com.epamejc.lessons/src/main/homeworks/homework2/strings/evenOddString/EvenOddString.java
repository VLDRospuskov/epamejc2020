package main.homeworks.homework2.strings.evenOddString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenOddString {
    private String input;
    private String parity = "";
    public void run() {
        inputString();
        oddOrEven();
    }

    private void oddOrEven() {
        if (parity.equals("even") || parity.equals("Even")) {
            evenChars();
        };
        if (parity.equals("odd") || parity.equals("Odd")) {
            oddChars();
        };
    }

    private void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
            System.out.println("Even or odd? ");
            parity = br.readLine();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void oddChars() {
        String output = "";
        if (input.length() >= 1) {
            for (int i = 0; i < input.length(); i += 2) {
                output += input.charAt(i);
            }
        }
        System.out.print(output);
    }

    private void evenChars() {
        String output = "";
        if (input.length() >= 2) {
            for (int i = 1; i < input.length(); i += 2) {
                output += input.charAt(i);
            }
        }
        System.out.print(output);
    }
}
