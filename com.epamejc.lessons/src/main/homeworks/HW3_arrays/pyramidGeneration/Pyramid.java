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
    }

    /**
     * Метод для проверки корректности и инициализации высоты пирамиды
     *
     * @param _scan
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
                }
            } catch (Exception ex) {
            }
        }
    }

    /**
     * Метод для генерации пирамиды на основе многомерного массива
     *
     * @return
     */
    private char[][] createPyramid() {
        char[][] pyramidCharArray = new char[pyramidHeight][2 * pyramidHeight - 1];

        try {
            for (int i = 0; i < pyramidHeight; i++) //Цикл по высоте пирамиды
            {
                for (int j = 0; j < pyramidHeight - i - 1; j++) //Заполняем пробелами слева
                {
                    pyramidCharArray[i][j] = ' ';
                }

                for (int k = pyramidHeight - 1 - i; k <= pyramidHeight - 1 + i; k++) { //Заполняем символами X
                    pyramidCharArray[i][k] = 'X';
                }

                for (int z = pyramidHeight + i; z < 2 * pyramidHeight - 1; z++) //Заполняем пробелами справа
                {
                    pyramidCharArray[i][z] = ' ';
                }
            }
            return pyramidCharArray;

        } catch (Exception ex) {
            return pyramidCharArray;
        }
    }

    /**
     * Метод для печати сгенерированной пирамиды в консоль
     *
     * @param charArray
     */
    private void printPyramid(char[][] charArray) {
        System.out.println("Generated pyramid is: ");
        int test = 10;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i].length; j++) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}


