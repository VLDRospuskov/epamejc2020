package main.HW2.Number2_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Array {

    private int first;
    private int second;
    private Scanner sc;


    public Array(Scanner sc) {
        this.sc = sc;
    }
    /* Создание двумерного массива и присвоение буквенных значений*/
    private char[][] makeArray(int a, int b) {
        char[][] charResult = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                charResult[i][j] = RandomChar();
            }
        }
        return charResult;
    }

    /*Метод генерирует случайное значение типа char*/
    private char RandomChar() {
        Random random = new Random();
        return (char) (random.nextInt(11) + 'a');
    }

    /*Вывод массива на экран*/
    private void printArray(char[][] array) {
        for (int i = 0; i < first; i++) {
            for (int j = 0; j < second; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void getInput() {
        try {
            first = sc.nextInt();
            second = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
        }
    }

    public void run() {
        System.out.println("Enter array size with space button between them: ");
        getInput();
        printArray(makeArray(first, second));
    }

}

