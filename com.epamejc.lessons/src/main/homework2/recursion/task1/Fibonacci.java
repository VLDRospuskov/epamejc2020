package main.homework2.recursion.task1;

import java.io.*;

public class Fibonacci {
    static {
        System.out.println("Enter the element number of the Fibonacci row" + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
                String fibString = reader.readLine();
                if (!fibString.equals("exit")) {
                    inputCheck(fibString);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    //проверка ввода - введено ли число не больше 45 (46 - уже за пределами int)
    private void inputCheck(String fibString) {
        while (true) {
            try {
                int fib = Integer.parseInt(fibString);
                if (fib <= 45) {
                    System.out.println(findFib(fib));
                } else {
                    System.out.println("Entered too big number. Please enter number less than or equal 45.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.Try again.");
            }
        }
    }


    private int findFib(int fib) {
        if (fib == 0) {
            return 0;
        }
        if (fib == 1) {
            return 1;
        }
        return findFib(fib - 1) + findFib(fib - 2);
    }
}
