package homework3.task2;

import HomeworksReaderAndPrinter.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class CreateArrayAndString {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter the sizes of the array (separated by a \"space button\")." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Enter the sizes:");
                String arraySize = reader.read();
                if (!arraySize.equalsIgnoreCase("exit")) {
                    try {
                        List<Integer> integers = inputCheck(arraySize);

                        char[][] array = createArray(integers.get(0), integers.get(1));
                        printer.print(arrayAsString(array));

                        String strategyOutput = choiceOfStrategy(array, reader);
                        printer.print(strategyOutput);

                    } catch (Exception e) {
                        printer.print("Incorrect input.Try again.");
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

    List<Integer> inputCheck(String arraySize) {
        String[] arraySizes = arraySize.split(" ");
        int firstSize = Integer.parseInt(arraySizes[0]);
        int secondSize = Integer.parseInt(arraySizes[1]);
        return Arrays.asList(firstSize, secondSize);
    }

    char[][] createArray(int firstSize, int secondSize) {
        char[][] array = new char[firstSize][secondSize];
        for (int i = 0; i < firstSize; i++) {
            for (int j = 0; j < secondSize; j++) {
                array[i][j] = (char) (97 + (int) (Math.random() * 25));
            }
        }
        return array;
    }

    String choiceOfStrategy(char[][] array, Reader reader) {
        String strategy = "";
        try {
            while (true) {
                System.out.print("Please enter strategy (A or B): ");
                strategy = reader.read();

                switch (strategy.toUpperCase()) {
                    case "A":
                        return createStringByStrategy(array, 0);
                    case "B":
                        return createStringByStrategy(array, 1);
                    case "exit":
                        reader.close();
                        System.exit(0);
                    default:
                        System.out.println("Incorrect input.Try again.");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return strategy;
    }

    String createStringByStrategy(char[][] array, int startIndex) {
        StringBuilder resultString = new StringBuilder();
        for (int i = startIndex; i < array.length; i = i + 2) {
            for (int j = startIndex; j < array[i].length; j = j + 2) {
                resultString.append(array[i][j]);
            }
        }
        return resultString.toString();
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