package main.homeworks.HW5_recursion.fibonacciNumber;

import java.util.Scanner;

public class FibonacciNumber {
    private boolean appInputExitTrigger = true;
    private int inputNumber = 0;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            enterNumber(scan);
            if (appInputExitTrigger) {
                System.out.println("Fibonacci number is: " + fibonacciCalc(inputNumber));
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Метол для рекурсивного вычисления числа Фибоначчи
     *
     * @param n исходное число
     * @return число Фибоначчи
     */
    private static int fibonacciCalc(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciCalc(n - 1) + fibonacciCalc(n - 2);
        }
    }

    /**
     * Метод для проверки корректности ввода и инициализации числа
     *
     * @param _scan объект сканера
     */
    private void enterNumber(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print("Enter integer number to calculate fibonacci number (in range 1 - 30: ");
            String inputString = _scan.nextLine();
            try {
                inputNumber = Integer.parseInt(inputString);
                if (inputNumber == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (inputNumber > 0 && inputNumber <= 30) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter correct number");
            }
        }
    }
}


