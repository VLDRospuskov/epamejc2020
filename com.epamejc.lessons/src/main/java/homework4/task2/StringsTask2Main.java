package homework4.task2;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class StringsTask2Main {

    public static void main(String[] args) {
        GenerateString generateString = new GenerateString();
        generateString.start(new ConsoleReader(), new ConsolePrinter());
    }
}
