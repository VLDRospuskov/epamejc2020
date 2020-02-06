package homeworks.HW3_arrays.arrayGenerationWithStrategies;

import homeworks.HW3_arrays.arrayGeneration.SystemMessages;

import java.util.Scanner;


public class TwoDimensionalArrayM2 {
    private boolean isExitNeeded = false;

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            while (!isExitNeeded) {
                System.out.println(SystemMessages.appStartMessage.getMessage());
                int linesNumber = defineLinesQuantity(scan);
                if (!isExitNeeded) {
                    int rowsNumber = defineRowsQuantity(scan);
                    int strategyNumber = defineStrategy(scan);
                    processArray(linesNumber, rowsNumber, strategyNumber);
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
     *
     */
    private void processArray(int linesQuantity, int rowsQuantity, int strategyNumber) {
        char[][] twoDimArray = new char[linesQuantity][rowsQuantity];
        fillCharArray(twoDimArray);
        printCharArray(twoDimArray);
        if (strategyNumber == 1) {
            System.out.println("Created string is: \n" + createStringStrategyA(twoDimArray));
        } else {
            System.out.println("Created string is: \n" + createStringStrategyB(twoDimArray));
        }
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества строк массива
     *
     * @param scan объект сканера
     */
    private int defineLinesQuantity(Scanner scan) {
        boolean linesInputExitTrigger = false;
        int linesQuantity = 0;
        while (!linesInputExitTrigger) {
            System.out.print(SystemMessages.inputLinesMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                linesQuantity = Integer.parseInt(inputString);
                if (linesQuantity == -1) {
                    isExitNeeded = true;
                    break;
                } else if (linesQuantity > 0 && linesQuantity <= 85) {
                    linesInputExitTrigger = true;
                } else {
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return linesQuantity;
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества столбцов массива
     *
     * @param scan объект сканера
     */
    private int defineRowsQuantity(Scanner scan) {
        boolean rowsInputExitTrigger = false;
        int rowsQuantity = 0;
        while (!rowsInputExitTrigger) {
            System.out.print(SystemMessages.inputRowsMessage.getMessage());
            String inputString = scan.nextLine();
            try {
                rowsQuantity = Integer.parseInt(inputString);
                if (rowsQuantity > 0 && rowsQuantity <= 85) {
                    rowsInputExitTrigger = true;
                } else {
                    System.out.println(SystemMessages.numberErrorMessage.getMessage());
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
        return rowsQuantity;
    }

    /**
     * Метод для проверки корректности ввода и инициализации номера стратегии
     *
     * @param scan объект сканера
     * @return номер стратегии
     */
    private int defineStrategy(Scanner scan) {
        boolean isCorrectStrategyInput = false;
        int strategyNumber = 0;
        while (!isCorrectStrategyInput) {
            System.out.print(SystemMessages.inputStrategyMessage.getMessage());
            String inputString = scan.nextLine();
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
     * @param twoDimArray объявленный массив
     */
    private void fillCharArray(char[][] twoDimArray) {
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = charGenerator();
            }
        }
    }

    /**
     * Метод для вывода сформированного двумерного массива в консоль
     *
     * @param twoDimArray сгенерированный массив
     */
    private void printCharArray(char[][] twoDimArray) {
        System.out.println("Generated array:");
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Метод для генерации строки на основании выбранной стратегии A и сгенерированного массива
     *
     * @param twoDimArray сгенерированный массив
     * @return сгенерированная строка
     */
    private String createStringStrategyA(char[][] twoDimArray) {
        String resultString = "";
        for (int i = 0; i < twoDimArray.length; i += 2) {
            for (int j = 0; j < twoDimArray[0].length; j += 2) {
                resultString += String.valueOf(twoDimArray[i][j]);
            }
        }
        return resultString;
    }

    /**
     * Метод для генерации строки на основании выбранной стратегии B и сгенерированного массива
     *
     * @param twoDimArray сгенерированный массив
     * @return сгенерированная строка
     */
    private String createStringStrategyB(char[][] twoDimArray) {
        String resultString = "";
        for (int i = 1; i < twoDimArray.length; i += 2) {
            for (int j = 1; j < twoDimArray[0].length; j += 2) {
                resultString += String.valueOf(twoDimArray[i][j]);
            }
        }
        return resultString;
    }
}


