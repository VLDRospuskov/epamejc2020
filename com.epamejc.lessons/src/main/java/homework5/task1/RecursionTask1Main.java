package homework5.task1;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class RecursionTask1Main {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.start(new ConsoleReader(), new ConsolePrinter());
    }
}
