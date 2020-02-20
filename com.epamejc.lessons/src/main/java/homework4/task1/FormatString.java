package homework4.task1;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class FormatString {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter some string and \"even\" or \"odd\". " + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Please enter the string:");
                String inputString = reader.read();
                if (!inputString.equalsIgnoreCase("exit")) {
                    try {
                        String resultString = evenOrOdd(inputString, reader);
                        printer.print(resultString);
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

    String evenOrOdd(String inputString, Reader reader) {
        String evenOdd = "";
        try {
            while (true) {
                System.out.println("Please enter \"even\" or \"odd\":");
                evenOdd = reader.read();

                switch (evenOdd) {
                    case "even":
                        return extractLettersFromString(inputString, 1);
                    case "odd":
                        return extractLettersFromString(inputString, 0);
                    case "exit":
                        System.exit(0);
                        reader.close();
                    default:
                        System.out.println("Incorrect input.Try again.");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        return evenOdd;
    }

    String extractLettersFromString(String inputString, int extractionOrder) {
        StringBuilder resultString = new StringBuilder();
        for (int i = extractionOrder; i < inputString.length(); i = i + 2) {
            resultString.append(inputString.charAt(i));
        }
        return resultString.toString();
    }
}
