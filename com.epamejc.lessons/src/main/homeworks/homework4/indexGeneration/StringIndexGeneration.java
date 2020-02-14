package main.homeworks.homework4.indexGeneration;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringIndexGeneration {

    private String input;

    public void run() {
        inputString();
        generateNewString();
    }

    private void inputString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter string: ");
            input = br.readLine();

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void generateNewString() {
        String newString = "";
        System.out.print("Enter index('-1' - the end): ");
        Scanner scanner = new Scanner(System.in);
        int index;
        while (true) {
            try {
                if (scanner.hasNextInt()) {
                    index = scanner.nextInt();
                } else {
                    scanner.next();
                    throw new Exception();
                }
                if (index == -1) {
                    break;
                }
                if (index >= input.length() || index < 0) {
                    throw new ArithmeticException();
                }
                newString += input.charAt(index);
                System.out.println(newString);
            } catch (Exception e) {
                System.out.println("Enter index from 0 to " + (input.length()-1));
            }
        }
        scanner.close();
    }

}
