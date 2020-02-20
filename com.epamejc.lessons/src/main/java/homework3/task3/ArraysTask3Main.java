package homework3.task3;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class ArraysTask3Main {

    public static void main(String[] args) {
        CreatePyramid createPyramid = new CreatePyramid();
        createPyramid.start(new ConsoleReader(), new ConsolePrinter());
    }
}
