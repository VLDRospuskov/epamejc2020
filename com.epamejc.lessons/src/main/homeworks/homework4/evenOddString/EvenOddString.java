package main.homeworks.homework4.evenOddString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenOddString {

    private String input;
    private String parity = "";

    public void run() {
        inputString();
    }

    private void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();
            System.out.println("Even or odd? ");
            do {
                parity = br.readLine();
            } while (!oddOrEven());
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean oddOrEven() {
        if (parity.equals("even") || parity.equals("Even")) {
            evenChars();
            return true;
        }
        if (parity.equals("odd") || parity.equals("Odd")) {
            oddChars();
            return true;
        }
        try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Enter even or odd.");
        }
        return false;
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
