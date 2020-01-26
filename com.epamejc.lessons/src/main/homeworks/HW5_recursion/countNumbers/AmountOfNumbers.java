package main.homeworks.HW5_recursion.countNumbers;


import java.util.Scanner;

public class AmountOfNumbers {
    private boolean appInputExitTrigger = true;
    private String inputString = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            enterString(scan);
            if (appInputExitTrigger) {
                System.out.println("Input string is: " + inputString);
                System.out.println("The number of digits per line: " + countNumbers(inputString));
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Метод для рекурсивного вычисления количества чисел в строке
     *
     * @param str исходная строка
     * @return количество чисел
     */
    private static int countNumbers(String str) {
        if (str.length() == 0)
            return 0;
        if (Character.isDigit(str.charAt(0)))
            return 1 + countNumbers(str.substring(1));
        return countNumbers(str.substring(1));
    }

    /**
     * Метод для проверки корректности и инициализации исходной строки
     *
     * @param _scan
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print("Type -1 tu exit or enter a string that contains at " +
                    "least one numeric character: ");
            inputString = _scan.nextLine();
            try {
                int exitTrigger = Integer.parseInt(inputString);
                if (exitTrigger == -1) {
                    appInputExitTrigger = false;
                    break;
                }
            } catch (Exception ex) {
            }
            if (inputString.length() > 0) {
                isInputCorrect = true;
            }
        }
    }
}


