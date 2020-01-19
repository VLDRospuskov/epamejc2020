package main.homework2.arrays.task1;

import java.io.*;

class CreateArray {
    static {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")." + "\n" +
                "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
        try {
            while (true) {
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
            System.out.println("Incorrect input. Try again.");
        }
    }


    //создание и вывод массива
    private void createArray(int firstSize, int secondSize) {
        char[][] result = new char[firstSize][secondSize];

        for (int i = 0; i < firstSize; i++) {
            for (int j = 0; j < secondSize; j++) {
                result[i][j] = (char) (97 + (int) (Math.random() * 25));
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}