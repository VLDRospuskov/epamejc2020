package main.homeworks.HW4_strings.evenOrOddString;

import java.util.Scanner;

public class EvenOrNotString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";
    private String filterType = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            enterString(scan);
            if (appInputExitTrigger) {
                enterFilterType(scan);
                if (appInputExitTrigger) {
                    System.out.println("Entered string: " + inputString);
                    System.out.println("Transformed string: " + transformString() + "\n");
                }
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Метод для проверки корректности и инициализации введенной строки
     *
     * @param _scan объект сканера
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print("Enter the string with length > 0. Type \"exit\" to finish program: ");
            inputString = _scan.nextLine();
            try {
                if (inputString.equals("exit")) {
                    appInputExitTrigger = false;
                    break;
                } else if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception ex) {
                System.out.println(FilterTypes.wrongArgument.getValue());
            }
        }
    }

    /**
     * Метод для проверки корректности и инициализации типа фильтра для строки (четные/нечетные символы)
     *
     * @param _scan объект сканера
     */
    private void enterFilterType(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print("Select characters to be removed from string (even or odd): ");
            filterType = _scan.nextLine();
            try {
                if (filterType.equals("exit")) {
                    appInputExitTrigger = false;
                    break;
                } else if (filterType.equals(FilterTypes.EVEN.getValue()) || filterType.equals(FilterTypes.ODD.getValue())) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(FilterTypes.wrongArgument.getValue());
            }
        }
    }

    /**
     * Метод для формирования конечной строки с учетом фильтра
     *
     * @return измененная строка без четных/нечетных символов
     */
    private String transformString() {
        StringBuilder charBox = new StringBuilder();
        if (filterType.equals(FilterTypes.EVEN.getValue())) {
            int counter = 1;
            while (counter < inputString.length()) {
                charBox.append(inputString.charAt(counter));
                counter += 2;
            }
        } else {
            int counter = 0;
            while (counter < inputString.length()) {
                charBox.append(inputString.charAt(counter));
                counter += 2;
            }
        }
        return charBox.toString();
    }
}


