package TestReaderAndPrinter;

import HomeworksReaderAndPrinter.Reader;

import java.util.List;

public class TestReader implements Reader {
    private int count = 0;
    private List<String> inputs;

    public TestReader(List<String> inputs) {
        this.inputs = inputs;
    }

    @Override
    public String read() {
        String result = inputs.get(count);
        count++;
        return result;
    }

    @Override
    public void close() {
    }
}
