package homework3.task1;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class ArraysTask1Main {

    public static void main(String[] args) {
        CreateArray createArray = new CreateArray();
        createArray.start(new ConsoleReader(), new ConsolePrinter());
    }
}
