package main.homeworks.HW4_strings.indexExchangeString;

import java.util.Scanner;

public class IndexedChangedString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";
    private int firstIndex = 0;
    private int secondIndex = 0;
    private final String regex = "(\\d{1,})\\s{0,}?.?\\s{0,}?(\\d{1,})";

    public void run() {
        Scanner scan = new Scanner(System.in);
        enterString(scan); //Ввели строку
        while (appInputExitTrigger) {
            enterIndexes(scan);
            if (appInputExitTrigger) {
                generateString();
            }
        }
        scan.close();
        System.out.println(IndexedChangedStringMessages.exitAppMessage.getValue());
    }

    /**
     * Метод для проверки корректности и инициализации введенной строки
     *
     * @param _scan
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(IndexedChangedStringMessages.enterStringMessage.getValue());
            inputString = _scan.nextLine();
            try {
                if (inputString.length() > 0) {
                    isInputCorrect = true;
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Метод для проверки корректности и инициализации индексов введенной строки
     *
     * @param _scan
     */
    private void enterIndexes(Scanner _scan) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.println(IndexedChangedStringMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String _inputString = _scan.nextLine();

            if (_inputString.equals("-1")) { //Проверяем условие выхода
                appInputExitTrigger = false;
                break;
            }

        }
    }

    /**
     * Метод для генерации строки на основе исходной строки и индексов для замены символов
     */
    private void generateString() {
        System.out.println("Entered string is: " + inputString);
        char[] inputStringArray = inputString.toCharArray();
        char index1 = inputStringArray[firstIndex];
        char index2 = inputStringArray[secondIndex];
        inputStringArray[firstIndex] = index2;
        inputStringArray[secondIndex] = index1;
        System.out.println("Result string is: " + new String(inputStringArray) + "\n");
    }
}
