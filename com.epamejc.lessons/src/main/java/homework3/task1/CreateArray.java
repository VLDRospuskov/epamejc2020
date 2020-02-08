package main.java.homework3.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CreateArray {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")." + "\n" +
                "To end the program - enter \"exit\".");
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

    private void inputCheck(String arraySize) {
        if (arraySize.contains(" ")) {
            String[] arraySizes = arraySize.split(" ");
            try {
                int firstSize = Integer.parseInt(arraySizes[0]);
                int secondSize = Integer.parseInt(arraySizes[1]);
                createAndPrintArray(firstSize, secondSize);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input.Try again.");
            }
        } else {
            System.out.println("Incorrect input. Try again.");
        }
    }

    private void createAndPrintArray(int firstSize, int secondSize) {
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