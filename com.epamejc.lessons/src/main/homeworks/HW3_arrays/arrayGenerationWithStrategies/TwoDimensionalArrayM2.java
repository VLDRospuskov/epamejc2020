package main.homeworks.HW3_arrays.arrayGenerationWithStrategies;

import main.homeworks.HW3_arrays.arrayGeneration.SystemMessages;

import java.util.Scanner;


public class TwoDimensionalArrayM2 {
    private boolean appInputExitTrigger = true;
    private boolean linesInputExitTrigger = true;
    private boolean rowsInputExitTrigger = true;
    private int linesQuantity = 0;
    private int rowsQuantity = 0;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (appInputExitTrigger) {
                System.out.println(SystemMessages.appStartMessage.getMessage());
                defineLinesQuantity(scan);
                if (appInputExitTrigger) {
                    defineRowsQuantity(scan);
                    if (appInputExitTrigger) {
                        processArray(scan);
                    }
                }
            }
        } catch (Exception Ex) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(SystemMessages.appFinishMessage.getMessage());
        }
    }

    /**
     * Метод для инициализации стратегии, генерации массива, его обработки и вывода в консоль
     *
     * @param _scan объект сканера
     */
    private void processArray(Scanner _scan) {
        char[][] twoDimArray = new char[linesQuantity][rowsQuantity];
        fillCharArray(twoDimArray);
        int strategyNumber = defineStrategy(_scan);
        printCharArray(twoDimArray);
        if (strategyNumber == 1) {
            System.out.println("Modified array: \n" + processArrayStrategyA(twoDimArray));
        } else {
            System.out.println("Modified array: \n" + processArrayStrategyB(twoDimArray));
        }
        linesInputExitTrigger = true;
        rowsInputExitTrigger = true;
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества строк массива
     *
     * @param _scan объект сканера
     */
    private void defineLinesQuantity(Scanner _scan) {
        while (linesInputExitTrigger) {
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
     * @param _scan объект сканера
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
     * @param _scan объект сканера
     * @return номер стратегии
     */
    private int defineStrategy(Scanner _scan) {
        boolean isCorrectStrategyInput = false;
        int strategyNumber = 0;
        while (!isCorrectStrategyInput) {
            System.out.print(SystemMessages.inputStrategyMessage.getMessage());
            String inputString = _scan.nextLine();
            try {
                strategyNumber = Integer.parseInt(inputString);
                if (strategyNumber == 1 || strategyNumber == 2) {
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
     * @param _twoDimArray объявленный массив
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
     * @param _twoDimArray сгенерированный массив
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
     * Метод для генерации строки на основании выбранной стратегии A и сгенерированного массива
     *
     * @param _twoDimArray сгенерированный массив
     * @return сгенерированная строка
     */
    private String processArrayStrategyA(char[][] _twoDimArray) {
        String resultString = "";
        for (int i = 0; i < linesQuantity; i += 2) {
            for (int j = 0; j < rowsQuantity; j += 2) {
                resultString += String.valueOf(_twoDimArray[i][j]);
            }
        }
        return resultString;
    }

    /**
     * Метод для генерации строки на основании выбранной стратегии B и сгенерированного массива
     *
     * @param _twoDimArray сгенерированный массив
     * @return сгенерированная строка
     */
    private String processArrayStrategyB(char[][] _twoDimArray) {
        String resultString = "";
        for (int i = 1; i < linesQuantity; i += 2) {
            for (int j = 1; j < rowsQuantity; j += 2) {
                resultString += String.valueOf(_twoDimArray[i][j]);
            }
        }
        return resultString;
    }
}


