package homework5.task3;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class DigitsAmount {

    void start(Reader reader, Printer printer) {
        System.out.println("Enter the number." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String inputStr = reader.read();
                if (!inputStr.equals("exit")) {
                    try {
                        int inputNumber = Integer.parseInt(inputStr);
                        int result = amountOfDigits(inputNumber);
                        printer.print(String.valueOf(result));
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

    int amountOfDigits(int inputInt) {
        if (inputInt < 10) {
            return 1;
        }
        return 1 + amountOfDigits(inputInt / 10);
    }
}
