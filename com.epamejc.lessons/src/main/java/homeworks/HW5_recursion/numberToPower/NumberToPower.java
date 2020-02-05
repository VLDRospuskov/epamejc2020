package homeworks.HW5_recursion.numberToPower;

import java.util.Scanner;

public class NumberToPower {
    private boolean appInputExitTrigger = true;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            long base = enterNumber(scan, "BASE");
            if (appInputExitTrigger) {
                long power = enterNumber(scan, "POWER");
                if (appInputExitTrigger) {
                    System.out.println(base + "^" + power + " is: " + powerNumber(base, power));
                }
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Метод для проверки корректности ввода и инициализации переменных базы и степени
     *
     * @param _scan объект сканера
     * @param type  тип переменной для формирования текстовой записи
     * @return база или степень
     */
    private long enterNumber(Scanner _scan, String type) {
        boolean isInputCorrect = false;
        long inputNumber = 0;
        while (!isInputCorrect) {
            System.out.print("Type -1 to exit or enter integer number for "
                    + type + " to calculate power of base (in range 1 - 15: ");
            String inputString = _scan.nextLine();
            try {
                inputNumber = Integer.parseInt(inputString);
                if (inputNumber == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (inputNumber > 0 && inputNumber <= 15) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter a correct number.");
            }
        }
        return inputNumber;
    }

    /**
     * Метод для рекурсивного вычисления степени числа
     *
     * @param number число (база)
     * @param power  степень
     * @return число в степени
     */
    private static long powerNumber(long number, long power) {
        if (power == 1)
            return number;
        return number * powerNumber(number, power - 1);
    }
}


