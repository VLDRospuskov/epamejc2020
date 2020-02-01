package main.homeworks.HW4_strings.stringReverse;

import java.util.Scanner;

public class ReversedString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (appInputExitTrigger) {
                enterString(scan);
                if (appInputExitTrigger) {
                    reverseStrings();
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(ReversedStringMessages.exitAppMessage.getValue());
        }
    }

    /**
     * Метод для ввода строки
     *
     * @param _scan объект сканера
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(ReversedStringMessages.enterStringMessage.getValue());
            inputString = _scan.nextLine();
            try {
                if (inputString.equals("exit")) {
                    appInputExitTrigger = false;
                    break;
                } else if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(ReversedStringMessages.enterStringError.getValue());
            }
        }
    }

    /**
     * Метод для разворота строк
     */
    private void reverseStrings() {
        System.out.println("Original string is: \n" + inputString);
        System.out.println("Reversed string is:");

        String[] splittedStrings = inputString.split("\\s+");
        for (String s : splittedStrings) {
            StringBuilder strBuilder = new StringBuilder(s);
            System.out.print(strBuilder.reverse().toString() + " ");
        }
        System.out.println();
    }
}
