package TestReaderAndPrinter;

import HomeworksReaderAndPrinter.Printer;

import java.util.ArrayList;
import java.util.List;

public class TestPrinter implements Printer {

    private List<String> outputs = new ArrayList<>();

    @Override
    public void print(String input) {
        outputs.add(input);
    }

    public List<String> getOutputs() {
        return outputs;
    }

    public void eraseState() {
        outputs = new ArrayList<>();
    }
}
