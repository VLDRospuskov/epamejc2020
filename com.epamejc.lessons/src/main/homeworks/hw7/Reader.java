package main.homeworks.hw7;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;

public class Reader {

    static char[] text;

    @SneakyThrows
    public static void readFile(String fileName) {
        text = new char[1024];
        FileReader fileReader = new FileReader(fileName);
        fileReader.read(text);
        System.out.println("Read the file via file reader");
    }

    @SneakyThrows
    public static void writeIntoFile(String fileName) {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(text);
        fileWriter.flush();
    }

}
