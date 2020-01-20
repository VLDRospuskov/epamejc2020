package main.HM2_Arrays;

import java.util.Scanner;

public class ArrayMethods {
    static int rows;
    static int colums;
    static char[][] values;

    private static void createArray() { // 2.1. Создать массив массивов, задается размерность на основании которое генерируются случайные символы типа char
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        rows = sc.nextInt();
        colums = sc.nextInt();
        values = new char[rows][colums];

        // Коды символов строчной лотиницы 97-122
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                values[i][j] = (char) (97 + (int)(Math.random() * 26));
            }
        }
    }

    public static void printArray() {
        createArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSomeValues() { // Сгенерировать массив массивов указав размерность, заполнить его случайными символами. Написать 2 стратегии, которые будут формировать строку на основе данного массива. Стратегия А - работает по принципу *_*_*, а стратегия B - работает по принципу _*_*_
        printArray();
        System.out.println("Enter strategy: A or B");
        Scanner sc = new Scanner(System.in);
        String modeStr = sc.nextLine();
        int modeInt;
        if (modeStr.equals("A")) modeInt = 0;
        else if (modeStr.equals("B")) modeInt = 1;
        else {
            System.out.println("Incorrect value");
            return;
        }

        String result = "";
        for (int i = modeInt; i < rows; i+=2) {
            for (int j = modeInt; j < colums; j+=2) {
                result += values[i][j];
            }
        }

        System.out.println(result);
    }

    public static void printPyramid() { // TODO 2.3
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter int value:");
        int size = sc.nextInt();

        char[][] Xs = new char[size][];
        for (int i = 0; i < size; i++) {
            Xs[i] = new char[size-i];
            for (int j = 0; j < size-i; j++) {
                Xs[i][j] = 'X';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i; j++) {
                System.out.print(Xs[i][j]);
            }
            System.out.println();
        }
    }
}
