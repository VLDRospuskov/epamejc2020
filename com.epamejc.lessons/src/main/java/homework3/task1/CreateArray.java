package homework3.task1;

import HomeworksReaderAndPrinter.*;
import HomeworksReaderAndPrinter.Reader;

import java.io.*;
import java.util.*;

class CreateArray {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String arraySize = reader.read();
                if (!arraySize.equalsIgnoreCase("exit")) {
                    try {

                        List<Integer> integers = inputCheck(arraySize);
                        char[][] result = createArray(integers.get(0), integers.get(1));
                        printer.print(arrayAsString(result));
                        System.out.println("Enter the sizes of the array:");
                    } catch (Exception e) {
                        System.out.println("Incorrect input.Try again.");
                    }
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    List<Integer> inputCheck(String arraySize) throws RuntimeException {
            String[] arraySizes = arraySize.split(" ");
            int firstSize = Integer.parseInt(arraySizes[0]);
            int secondSize = Integer.parseInt(arraySizes[1]);
            return Arrays.asList(firstSize, secondSize);
    }

      char[][] createArray(int firstSize, int secondSize) {
        char[][] result = new char[firstSize][secondSize];
        for (int i = 0; i < firstSize; i++) {
            for (int j = 0; j < secondSize; j++) {
                result[i][j] = (char) (97 + (int) (Math.random() * 25));
            }
        }
        return result;
    }

    private String arrayAsString(char[][] input) {
        StringBuilder builder = new StringBuilder();
        for (char[] chars : input) {
            for (char aChar : chars) {
                builder.append(aChar);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}