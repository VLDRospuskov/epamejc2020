package homework4.task3;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ChangeString {

    protected void start(Reader reader, Printer printer) {
        System.out.println("Enter some string and then enter indices of letters which you want to replace " +
                "(separated by a \", \")" + "\n" + "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.read();
                if (!inputString.equals("exit")) {
                    try {
                        List<Integer> indices = inputIndicesCheck(reader);
                        printer.print(changeString(inputString, indices.get(0), indices.get(1)));
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

    List<Integer> inputIndicesCheck(Reader reader) {
        List<Integer> indices = new ArrayList<>(2);
        try {
            System.out.print("Enter indices: ");
            String inputIndices = reader.read();

            if (inputIndices.equalsIgnoreCase("exit")) {
                System.exit(0);
                reader.close();
            } else {
                String[] indicesStr = inputIndices.split(", ");
                indices.add(Integer.valueOf(indicesStr[0]));
                indices.add(Integer.valueOf(indicesStr[1]));
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return indices;
    }

    String changeString(String inputString, int index1, int index2) {
        StringBuilder result = new StringBuilder(inputString);
        result.delete(index1, index1 + 1);
        result.insert(index1, inputString.charAt(index2));
        result.delete(index2, index2 + 1);
        result.insert(index2, inputString.charAt(index1));
        return result.toString();
    }
}

