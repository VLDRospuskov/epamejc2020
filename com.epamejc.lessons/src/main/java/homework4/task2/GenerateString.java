package homework4.task2;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class GenerateString {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter some string and then enter the indices of the letters you want to add " +
                "to the new string." + "\n" + "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.read();
                if (!inputString.equals("exit")) {
                    try {
                        generateString(inputString, reader, printer);
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

    void generateString(String inputString, Reader reader, Printer printer) {
        StringBuilder resultString = new StringBuilder();
        String letter;
        System.out.println("Enter the indices. If you want restart program with new string - enter \"end\".");
        try {
            while (true) {
                letter = reader.read();
                if (letter.equals("end")) {
                    break;
                } else if (letter.equals("exit")) {
                    reader.close();
                    System.exit(0);
                } else {
                    try {
                        int letterIndex = Integer.parseInt(letter);
                        resultString.append(inputString.charAt(letterIndex));
                        printer.print(resultString.toString());
                    } catch (Exception e) {
                        System.out.println("Incorrect input.Try again.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
