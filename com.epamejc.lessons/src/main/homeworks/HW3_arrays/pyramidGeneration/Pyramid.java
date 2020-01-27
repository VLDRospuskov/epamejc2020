package main.homeworks.HW3_arrays.pyramidGeneration;

import java.util.Scanner;

public class Pyramid {
    private boolean appInputExitTrigger = true;
    private int pyramidHeight;

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (appInputExitTrigger) {
            definePyramidHeight(scan);
            if (appInputExitTrigger) {
                printPyramid(createPyramid());
            }
        }
        scan.close();
        System.out.println("Program ends. Goodbye.");
    }

    /**
     * Метод для проверки корректности и инициализации высоты пирамиды
     *
     * @param _scan объект сканера
     */
    private void definePyramidHeight(Scanner _scan) {
        boolean isInputCorrect = false;
        while (!isInputCorrect) {
            System.out.print("Enter the height of the pyramid (Integer number from 1 to 55) or enter -1 to exit: ");
            String inputString = _scan.nextLine();
            try {
                pyramidHeight = Integer.parseInt(inputString);
                if (pyramidHeight == -1) {
                    appInputExitTrigger = false;
                    break;
                } else if (pyramidHeight > 0 && pyramidHeight <= 55) {
                    isInputCorrect = true;
                } else {
                    throw new ArithmeticException();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Enter correct number.");
            }
        }
    }

    /**
     * Метод для инициализации пирамиды на основе многомерного массива
     *
     * @return сгенерированный массив
     */
    private char[][] createPyramid() {
        char[][] pyramidCharArray = new char[pyramidHeight][2 * pyramidHeight - 1];
        try {
            for (int i = 0; i < pyramidCharArray.length; i++) {
                for (int j = 0; j < pyramidCharArray[i].length; j++) {
                    pyramidCharArray[i][j] = ' ';
                }
            }
            generatePyramid(pyramidCharArray);
        } catch (Exception exc) {
            System.out.println("An error occurred while creating the pyramid");
        }
        return pyramidCharArray;
    }

    /**
     * Метод для заполнения созданного массива символьными элементами
     *
     * @param _pyramidArray объявленный массив
     */
    private void generatePyramid(char[][] _pyramidArray) {
        for (int i = 0; i < pyramidHeight; i++) {
            for (int k = pyramidHeight - 1 - i; k <= pyramidHeight - 1 + i; k++) { //Заполняем символами X
                _pyramidArray[i][k] = 'X';
            }
        }
    }

    /**
     * Метод для печати сгенерированной пирамиды в консоль
     *
     * @param charArray сгенерированный массив
     */
    private void printPyramid(char[][] charArray) {
        System.out.println("Generated pyramid is: ");
        try {
            for (int i = 0; i < charArray.length; i++) {
                for (int j = 0; j < charArray[i].length; j++) {
                    System.out.print(charArray[i][j]);
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("An error occurred while printing the pyramid");
        } finally {
            System.out.println();
        }
    }
}



