package main.homework2.arrays.task2;

import java.io.*;

public class CreateArray {
    static {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
                System.out.println("Enter the sizes:");
                String arraySize = reader.readLine();
                if (!arraySize.equals("exit")) {
                    inputCheck(arraySize);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    //проверка введенных данных (два числа через пробел)
    private void inputCheck(String arraySize) {
        if (arraySize.contains(" ")) {
            String[] arraySizes = arraySize.split(" ");
            try {
                int firstSize = Integer.parseInt(arraySizes[0]);
                int secondSize = Integer.parseInt(arraySizes[1]);
                createArray(firstSize, secondSize);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.Try again.");
            }
        } else {
            System.out.println("Incorrect input.Try again.");
        }
    }


    //создание массива, выбор стратегии
    private void createArray(int firstSize, int secondSize) {
        char[][] resultArray = new char[firstSize][secondSize];

        for (int i = 0; i < firstSize; i++) {
            for (int j = 0; j < secondSize; j++) {
                resultArray[i][j] = (char) (97 + (int) (Math.random() * 25));
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }

        try {
            while (true) {
                System.out.print("Please enter strategy: ");
                String strategy = reader.readLine();
                if (strategy.equals("A")) {
                    strategyA(resultArray);
                    break;
                } else if (strategy.equals("B")) {
                    strategyB(resultArray);
                    break;
                } else if (strategy.equals("exit")) {
                    System.exit(0);
                    reader.close();
                } else {
                    System.out.println("Incorrect input.Try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    private void strategyA(char[][] resultArray) {
        String resultA = "";
        for (int i = 0; i < resultArray.length; i = i + 2) {
            for (int j = 0; j < resultArray[i].length; j = j + 2) {
                resultA += resultArray[i][j];
            }
        }
        System.out.println(resultA);
    }


    private void strategyB(char[][] resultArray) {
        String resultB = "";
        for (int i = 1; i < resultArray.length; i = i + 2) {
            for (int j = 1; j < resultArray[i].length; j = j + 2) {
                resultB += resultArray[i][j];
            }
        }
        System.out.println(resultB);
    }
}