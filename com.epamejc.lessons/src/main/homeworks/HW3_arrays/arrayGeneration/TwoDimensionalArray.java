package main.homeworks.HW3_arrays.arrayGeneration;

import java.util.Scanner;


public class TwoDimensionalArray {
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
                        generateArray();
                    }
                }
            }
        } catch (Exception excp) {
            System.out.println("Something went wrong");
        } finally {
            scan.close();
            System.out.println(SystemMessages.appFinishMessage.getMessage());
        }
    }

    /**
     * Метод для генерации двумерного массива и его вывода в консоль
     */
    private void generateArray() {
        char[][] twoDimArray = new char[linesQuantity][rowsQuantity];
        fillCharArray(twoDimArray);
        printCharArray(twoDimArray);
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
                    throw new ArithmeticException();
                }
            } catch (Exception arExc) {
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
                    throw new ArithmeticException();
                }
            } catch (Exception exc) {
                System.out.println(SystemMessages.numberErrorMessage.getMessage());
            }
        }
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
        System.out.println(SystemMessages.outputMessage.getMessage());
        for (int i = 0; i < linesQuantity; i++) {
            for (int j = 0; j < rowsQuantity; j++) {
                System.out.print(" " + _twoDimArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}

