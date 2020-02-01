package main.homeworks.HW4_strings.indexStringGeneration;

import java.util.Scanner;

public class IndexStringGeneration {
    private boolean appInputExitTrigger = true;
    private String inputString = "";
    private int indexOfString = 0;
    private String resultString = "";

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            enterString(scan);
            while (appInputExitTrigger) {
                enterIndex(scan);
                if (appInputExitTrigger) {
                    generateString();
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(IndexStringGenerationMessages.exitAppMessage.getValue());
        }
    }

    /**
     * Метод для проверки корректности и инициализации введенной строки
     *
     * @param _scan объект сканера
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(IndexStringGenerationMessages.enterStringMessage.getValue());
            inputString = _scan.nextLine();
            try {
                if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(IndexStringGenerationMessages.enterStringError.getValue());
            }
        }
    }

    /**
     * Метод для проверки корректности и инициализации индекса введенной строки
     *
     * @param _scan объект сканера
     */
    private void enterIndex(Scanner _scan) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.print(IndexStringGenerationMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String _inputString = _scan.nextLine();
            try {
                indexOfString = Integer.parseInt(_inputString);
                if (indexOfString == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (indexOfString >= 0 && indexOfString <= maxIndex) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(IndexStringGenerationMessages.enterIndexError.getValue());
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
        charBox.append(inputString.charAt(indexOfString));
        resultString = resultString + charBox.toString();
        System.out.println("Result string is: " + resultString + "\n");
    }
}


