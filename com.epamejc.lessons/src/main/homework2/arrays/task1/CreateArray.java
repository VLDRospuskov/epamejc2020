package main.homework2.arrays.task1;

import java.io.*;

class CreateArray {
    {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")" + "\n" +
                "To end the program - enter exit");
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String arraySize;


    protected void start() { //перезапуск в цикле; если введено "exit" - завершение
        try {
            while (true) {
                arraySize = reader.readLine();
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


    protected void inputCheck(String arraySize) { //проверка введенных данных

        if (arraySize.contains(" ")) {
            String[] arraySizes = arraySize.split(" ");
            try {
                int firstSize = Integer.parseInt(arraySizes[0]);
                int secondSize = Integer.parseInt(arraySizes[1]);
                createArray(firstSize, secondSize);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        } else {
            System.out.println("Некорректный ввод");
        }
    }


    protected void createArray(int firstSize, int secondSize) { //создание и вывод массива

        char[][] result = new char[firstSize][secondSize];

        for (char[] innerArray : result) {
            for (char innerValue : innerArray) {
                innerValue = (char) (97 + (int) (Math.random() * 25));
                System.out.print(innerValue + " ");
            }
            System.out.println();
        }
    }
}