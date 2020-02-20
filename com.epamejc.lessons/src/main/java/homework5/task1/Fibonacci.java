package homework5.task1;

import HomeworksReaderAndPrinter.Printer;
import HomeworksReaderAndPrinter.Reader;

import java.io.IOException;

class Fibonacci {

    protected void start(Reader reader, Printer printer) {
        System.out.println("Enter the element number of the Fibonacci row. " +
                "Please enter number less than or equal 45." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String fibString = reader.read();
                if (!fibString.equalsIgnoreCase("exit")) {
                    try {
                        int fib = inputCheck(fibString);
                        int result = findFib(fib);
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

    int inputCheck(String fibString) throws Exception {
        int fib = Integer.parseInt(fibString);
        if (fib > 45) {
            throw new Exception();
        }
        return fib;
    }

    int findFib(int fib) {
        if (fib == 0) {
            return 0;
        }
        if (fib == 1) {
            return 1;
        }
        return findFib(fib - 1) + findFib(fib - 2);
    }
}
