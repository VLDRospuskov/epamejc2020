package homework4.task4;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class ReverseWords {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter some string." + "\n" + "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.read();
                if (!inputString.equalsIgnoreCase("exit")) {
                    String reverseInput = reverseWord(inputString);
                    printer.print(reverseInput);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    String reverseWord(String inputString) {
        String[] words = inputString.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            word = new StringBuilder(word).reverse().toString();
            stringBuilder.append(word).append(" ");
        }

        String resultReverseString = stringBuilder.toString();
        resultReverseString = resultReverseString.substring(0, resultReverseString.length() - 1);
        return resultReverseString;
    }
}
