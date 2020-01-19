package main.homework2.arrays.task3;

import java.io.*;
import java.util.Arrays;

public class CreatePyramid {
    static {
        System.out.println("Enter the integer - it will be height of your pyramid." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
                String height = reader.readLine();
                if (!height.equals("exit")) {
                    createArray(height);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    //проверка, введено ли целое число -> создание массива
    private void createArray(String height) {
        try {
            int intHeight = Integer.parseInt(height);
            String[][] xArray = new String[intHeight][intHeight];
            for (String[] s : xArray) {
                Arrays.fill(s, "X");
            }
            createPyramid(xArray);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.Try again.");
        }
    }


    //вывод пирамиды
    private void createPyramid(String[][] xArray) {
        for (int i = xArray.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print(xArray[i][j]);
            }
            System.out.println();
        }
    }
}
