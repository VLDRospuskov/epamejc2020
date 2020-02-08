package main.java.homework5.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitsAmount {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() throws IOException {
        System.out.println("Enter the number." + "\n" +
                "To end the program - enter \"exit\".");
        while (true) {
            String inputStr = reader.readLine();

            if (!inputStr.equals("exit")) {
                inputCheck(inputStr);
            } else {
                reader.close();
                break;
            }
        }
    }

    private void inputCheck(String inputStr) {
        try {
            int inputInt = Integer.parseInt(inputStr);
            System.out.println(amountOfDigits(inputInt));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.Try again.");
        }
    }

    private int amountOfDigits(int inputInt) {
        if (inputInt < 10) {
            return 1;
        }
        return 1 + amountOfDigits(inputInt / 10);
    }
}
