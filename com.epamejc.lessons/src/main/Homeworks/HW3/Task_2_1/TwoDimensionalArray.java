package main.Homeworks.HW3.Task_2_1;

import java.util.Scanner;

/**
 * Класс для реализации логики заполнения двумерного массива
 */
public class TwoDimensionalArray {
    boolean appInputExitTrigger = true;
    boolean linesInputExitTrigger = true;
    boolean rowsInputExitTrigger = true;
    int linesQuantity = 0;
    int rowsQuantity = 0;

    public void run() {
        //Считываем данные из консоли
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) { //Пока не введено значение -1
            System.out.println(SystemMessages.appStartMessage.getMessage());
            defineLinesQuantity(scan);
            if (appInputExitTrigger) { //Здесь уже могли ввести -1 -> надо снова проверить
                defineRowsQuantity(scan);
                if (appInputExitTrigger) {
                    char[][] twoDimArray = new char[linesQuantity][rowsQuantity]; //Объявление массива
                    fillCharArray(twoDimArray); //Заполнение массива случайными символами А-z
                    printCharArray(twoDimArray); //Вывод массива в консоль
                    linesInputExitTrigger = true; //Для возможности повторного ввода строк и столбцов
                    rowsInputExitTrigger = true;
                } else {
                    scan.close();
                    System.out.println(SystemMessages.appFinishMessage.getMessage());
                    break;
                }
            } else {
                scan.close();
                System.out.println(SystemMessages.appFinishMessage.getMessage());
                break;
            }
        }
    }

    /**
     * Метод для проверки корректности ввода и инициализации количества строк массива
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
     * Метод для случайной генерации символа в пределах A-z
     * @return сгенерированный символ
     */
    private char charGenerator() {
        int rnd = (int) (Math.random() * 52);
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);
    }

    /**
     * Метод для заполнения массива сгенерированными случайными символами
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
     * @param _twoDimArray
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
