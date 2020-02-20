package HomeworksReaderAndPrinter;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String input) {
        System.out.println(input);
    }
}
