package main.homeworks.HW4_strings.indexExchangeString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexedChangedString {
    private boolean appInputExitTrigger = true;
    private String inputString = "";
    private int firstIndex = 0;
    private int secondIndex = 0;
    private final String regex = "(\\d{1,})\\s{0,}?.?\\s{0,}?(\\d{1,})";

    public void run() {
        Scanner scan = new Scanner(System.in);
        enterString(scan);
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
     * @param _scan объект сканера
     */
    private void enterString(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print(IndexedChangedStringMessages.enterStringMessage.getValue());
            inputString = _scan.nextLine();
            try {
                if (inputString.length() > 0) {
                    isInputCorrect = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception ex) {
                System.out.println(IndexedChangedStringMessages.wrongStringArgument.getValue());
            }
        }
    }

    /**
     * Метод для ввода индексов
     *
     * @param _scan объект сканера
     */
    private void enterIndexes(Scanner _scan) {
        boolean isInputCorrect = false;
        int maxIndex = inputString.length() - 1;
        while (!isInputCorrect) {
            System.out.println("Entered string is: " + inputString);
            System.out.print(IndexedChangedStringMessages.enterIndexMessage.getValue() + maxIndex + "): ");
            String inputString = _scan.nextLine();

            if (inputString.equals("-1")) {
                appInputExitTrigger = false;
                break;
            } else {
                isInputCorrect = parseIndexes(inputString);
            }
        }
    }

    /**
     * Метод для инициализации индексов
     * @param _inputIndexes введенная строка с индексами
     * @return флаг, корректно ли введены индексы
     */
    private boolean parseIndexes(String _inputIndexes) {
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(_inputIndexes);
        try {
            if (matcher.find()) {
                return checkIndexes(matcher);
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch (Exception ex) {
            System.out.println(IndexedChangedStringMessages.wrongNumberArgument.getValue());
            return false;
        }
    }

    /**
     * Метод для проверки введенных значений индексов
     * @return флаг, имеют ли индексы допустимые значения
     */
    private boolean checkIndexes(Matcher _matcher) throws IllegalArgumentException {
        if (_matcher.groupCount() == 2) {
            firstIndex = Integer.parseInt(_matcher.group(1));
            secondIndex = Integer.parseInt(_matcher.group(2));
            if (firstIndex >= 0 && secondIndex >=0 && firstIndex <= inputString.length()-1
                    && secondIndex <= inputString.length()-1) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
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