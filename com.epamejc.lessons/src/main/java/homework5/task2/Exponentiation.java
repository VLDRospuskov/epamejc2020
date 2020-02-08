package main.java.homework5.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exponentiation {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() throws IOException {
        System.out.println("Enter a number and then enter the degree to which you want to raise it." + "\n" +
                "To end the program - enter \"exit\".");
        while (true) {
            System.out.println("Input the number:");
            String numberStr = reader.readLine();

            if (!numberStr.equals("exit")) {
                inputCheck(numberStr);
            } else {
                reader.close();
                break;
            }
        }
    }

    private void inputCheck(String numberStr) throws IOException {
        System.out.println("Input the pow of number:");
        String powStr = reader.readLine();

        if (powStr.equals("exit")) {
            System.exit(0);
            reader.close();
        } else {
            try {
                int number = Integer.parseInt(numberStr);
                int pow = Integer.parseInt(powStr);
                System.out.println(exponentiation(number, pow));

            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.Try again.");
            }
        }
    }

    private int exponentiation(int number, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return number;
        }
        return number * exponentiation(number, pow - 1);
    }
}

