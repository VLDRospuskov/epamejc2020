package homework4.task3;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class StringsTask3Main {

    public static void main(String[] args) {
        ChangeString changeString = new ChangeString();
        changeString.start(new ConsoleReader(), new ConsolePrinter());
    }
}
