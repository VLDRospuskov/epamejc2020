package main.Homeworks.HW3.Task_3_2;

import java.util.Scanner;

public class IndexedString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";
    private int indexOfString = 0;
    private String resultString = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        enterString(scan); //Ввели строку
        while (appInputExitTrigger) {
            enterIndex(scan);
            if (appInputExitTrigger) {
                generateString();
            }
        }
        scan.close();
        System.out.println(IndexedStringMessages.exitAppMessage.getValue());
    }

    /**
     * Метод для проверки корректности и инициализации введенной строки
     *
     * @param _scan
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(IndexedStringMessages.enterStringMessage.getValue());
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
     * Метод для проверки корректности и инициализации индекса введенной строки
     *
     * @param _scan
     */
    private void enterIndex(Scanner _scan) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.print(IndexedStringMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String _inputString = _scan.nextLine();
            try {
                indexOfString = Integer.parseInt(_inputString);
                if (indexOfString == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (indexOfString >= 0 && indexOfString <= maxIndex) {
                    isInputCorrect = true;
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Метод для генерации новой строки на основании введенной строки, указанного индекса
     * и предыдущей итерации генерации
     */
    private void generateString() {
        System.out.println("Entered string is: " + inputString);
        StringBuilder charBox = new StringBuilder();
        charBox.append(inputString.charAt(indexOfString)); //Добавляем символ
        resultString = resultString + charBox.toString();
        System.out.println("Result string is: " + resultString + "\n");
    }
}

