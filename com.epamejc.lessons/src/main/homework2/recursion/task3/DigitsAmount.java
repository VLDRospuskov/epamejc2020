package main.homework2.recursion.task3;

import java.io.*;

public class DigitsAmount {
    static {
        System.out.println("Enter the number." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() throws IOException {

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

    //проверка, введено ли целое число
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
