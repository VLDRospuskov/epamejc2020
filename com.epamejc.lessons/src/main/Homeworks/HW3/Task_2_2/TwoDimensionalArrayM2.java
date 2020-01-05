package main.Homeworks.HW3.Task_2_2;

import main.Homeworks.HW3.Task_2_1.SystemMessages;

import java.util.Scanner;

/**
 * Класс для реализации логики заполнения двумерного массива
 */
public class TwoDimensionalArrayM2 {
    private boolean appInputExitTrigger = true;
    private boolean linesInputExitTrigger = true;
    private boolean rowsInputExitTrigger = true;
    private int linesQuantity = 0;
    private int rowsQuantity = 0;

    public void run() {
        //Считываем данные из консоли
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) { //Пока не введено значение -1
            System.out.println(SystemMessages.appStartMessage.getMessage());
            defineLinesQuantity(scan);
            if (appInputExitTrigger) { //Проверяем условие выхода на стадии ввода числа строк
                defineRowsQuantity(scan);
                if (appInputExitTrigger) { //Проверяем условие выхода на стадии ввода числа столбцов
                    char[][] twoDimArray = new char[linesQuantity][rowsQuantity];
                    fillCharArray(twoDimArray); //Заполнение массива случайными символами А-z
                    int strategyNumber = defineStrategy(scan);
                    if (appInputExitTrigger) { //Проверяем условие выхода на стадии ввода номера стратегии
                        printCharArray(twoDimArray); //Вывод массива в консоль
                        System.out.println("Modified array: \n" + processArrayWithStrategy(twoDimArray, strategyNumber));
                        linesInputExitTrigger = true; //Для возможности повторного ввода строк и столбцов
                        rowsInputExitTrigger = true;
                    }
                }
            }
        }
        scan.close();
        System.out.println(SystemMessages.appFinishMessage.getMessage());
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества строк массива
     *
     * @param _scan
     */
    private void defineLinesQuantity(Scanner _scan) {
        while (linesInputExitTrigger) { //Пока не ввели верное значение
            System.out.print(SystemMessages.inputLinesMessage.getMessage());
            String inputString = _scan.nextLine();
            try {
                linesQuantity = Integer.parseInt(inputString);
                if (linesQuantity == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (linesQuantity > 0 && linesQuantity <= 85) {
                    linesInputExitTrigger = false;
                } else {
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества столбцов массива
     *
     * @param _scan
     */
    private void defineRowsQuantity(Scanner _scan) {
        while (rowsInputExitTrigger) {
            System.out.print(SystemMessages.inputRowsMessage.getMessage());
            String inputString = _scan.nextLine();
            try {
                rowsQuantity = Integer.parseInt(inputString);
                if (rowsQuantity == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (rowsQuantity > 0 && rowsQuantity <= 85) {
                    rowsInputExitTrigger = false;
                } else {
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
    }

    /**
     * Метод для проверки корректности ввода и инициализации номера стратегии
     *
     * @param _scan
     * @return
     */
    private int defineStrategy(Scanner _scan) {
        boolean isCorrectStrategyInput = false;
        int strategyNumber = 0;
        while (!isCorrectStrategyInput) {
            System.out.print(SystemMessages.inputStrategyMessage.getMessage());
            String inputString = _scan.nextLine();
            try {
                strategyNumber = Integer.parseInt(inputString);
                if (strategyNumber == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (strategyNumber == 1 || strategyNumber == 2) {
                    isCorrectStrategyInput = true;
                } else {
                    System.out.println(SystemMessages.strategyErrorMessage.getMessage());
                }
            } catch (Exception ex) {
                System.out.println(SystemMessages.strategyErrorMessage.getMessage());
            }
        }
        return strategyNumber;
    }

    /**
     * Метод для случайной генерации символа в пределах A-z
     *
     * @return сгенерированный символ
     */
    private char charGenerator() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }

    /**
     * Метод для заполнения массива сгенерированными случайными символами
     *
     * @param _twoDimArray
     */
    private void fillCharArray(char[][] _twoDimArray) {
        for (int i = 0; i < linesQuantity; i++) {
            for (int j = 0; j < rowsQuantity; j++) {
                _twoDimArray[i][j] = charGenerator();
            }
        }
    }

    /**
     * Метод для вывода сформированного двумерного массива в консоль
     *
     * @param _twoDimArray
     */
    private void printCharArray(char[][] _twoDimArray) {
        System.out.println("Generated array:");
        for (int i = 0; i < linesQuantity; i++) {
            for (int j = 0; j < rowsQuantity; j++) {
                System.out.print(" " + _twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Метод для генерации строки на основании выбранной стратегии и сгенерированного массива
     *
     * @param _twoDimArray
     * @param _strategyNumber
     * @return
     */
    private String processArrayWithStrategy(char[][] _twoDimArray, int _strategyNumber) {
        String resultString = "";
        if (_strategyNumber == 1) //Стратегия для четных индексов
        {
            for (int i = 0; i < linesQuantity; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < rowsQuantity; j++) {
                        if (j % 2 == 0) {
                            resultString = resultString + _twoDimArray[i][j];
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        } else { //Стратегия для нечетных индексов
            for (int i = 0; i < linesQuantity; i++) {
                if (i % 2 != 0) {
                    for (int j = 0; j < rowsQuantity; j++) {
                        if (j % 2 != 0) {
                            resultString = resultString + _twoDimArray[i][j];
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return resultString;
    }
}


