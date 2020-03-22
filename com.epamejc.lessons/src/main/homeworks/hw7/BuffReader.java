package main.homeworks.hw7;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class BuffReader {

    public static String s;

    @SneakyThrows
    public static void readFile(String fileName) {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        s = reader.readLine();
        System.out.println("Read the file via BufferedReader");
    }

    @SneakyThrows
    public static void writeIntoFile(String fileName) {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(s);
        fileWriter.flush();
    }
}
