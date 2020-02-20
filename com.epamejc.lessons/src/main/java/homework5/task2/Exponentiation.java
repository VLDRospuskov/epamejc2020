package homework5.task2;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class Exponentiation {

    protected void start(Reader reader, Printer printer) {
        System.out.println("Enter a number and then enter the degree to which you want to raise it." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Input the number:");
                String numberStr = reader.read();
                if (!numberStr.equals("exit")) {
                    try {
                        int inputNumber = Integer.parseInt(numberStr);

                        System.out.println("Input the pow of number:");
                        int inputPow = Integer.parseInt(reader.read());

                        int result = exponentiation(inputNumber, inputPow);
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

    int exponentiation(int number, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return number;
        }
        return number * exponentiation(number, pow - 1);
    }
}

