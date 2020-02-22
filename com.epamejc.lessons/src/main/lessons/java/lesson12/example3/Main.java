package lessons.java.lesson12.example3;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        writeIntoFile();
        readFile();
    }

    @SneakyThrows
    private static void readFile() {
        FileReader fileReader = new FileReader("my_text.txt");
        char[] chars = new char[100];
        fileReader.read(chars, 0, 5);
        System.out.println(Arrays.toString(chars));
    }

    @SneakyThrows
    private static void writeIntoFile() {
        FileWriter fileWriter = new FileWriter("my_text.txt");
        fileWriter.write("Hello world");
        fileWriter.flush();
    }
}
