package homework4.task4;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class StringsTask4Main {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        reverseWords.start(new ConsoleReader(), new ConsolePrinter());
    }
}
