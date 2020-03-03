package homeworks.homework02;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class ArrayMethodsTest {

    ArrayMethods arrayMethods = new ArrayMethods();
    private BufferedReader reader;

    @Test
    public void testCreateArrayCorrect() {
        String input = "4\n3";
        mockReader(input);
        arrayMethods.setReader(reader);

        arrayMethods.createArray();
        arrayMethods.printArray(); // TODO как тестировать методы, где нечего сравнивать в ассерте?
    }

    @Test (expected = NumberFormatException.class)
    public void testCreateArrayIncorrect() {
        String input = "4.6\nv";
        mockReader(input);
        arrayMethods.setReader(reader);

        arrayMethods.createArray();
        arrayMethods.printArray();
    }

    @Test
    public void testPrintWithStrategy() {
        String input = "4\n4\nA";
        mockReader(input);
        arrayMethods.setReader(reader);

        arrayMethods.createArray();
        arrayMethods.printWithStrategy();
    }

    @Test
    public void testPrintPyramid() {
        String input = "4";
        mockReader(input);
        arrayMethods.setReader(reader);

        arrayMethods.printPyramid();
    }

    // TODO можно ли так замокать?
    private void mockReader(String str) {
        byte[] bytes = str.getBytes();
        reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
    }

}
