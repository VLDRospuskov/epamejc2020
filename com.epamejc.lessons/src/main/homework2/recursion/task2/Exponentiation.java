package main.homework2.recursion.task2;

import java.io.*;

public class Exponentiation {
    static {
        System.out.println("Enter a number and then enter the degree to which you want to raise it." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() throws IOException {
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


    //проверка, введены ли целые числа
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

