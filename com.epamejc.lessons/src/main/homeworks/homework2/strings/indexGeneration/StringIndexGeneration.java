package main.homeworks.homework2.strings.indexGeneration;

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
        while (true){
            index = scanner.nextInt();
            if (index == -1) {
                break;
            }
            newString += input.charAt(index);
            System.out.println(newString);
        };
        scanner.close();
    }
}
