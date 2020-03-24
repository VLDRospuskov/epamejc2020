package main.homeworks.homework7;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Text {

    @SneakyThrows
    public static void readFile() {
        long start = System.currentTimeMillis();
        String fileName = "com.epamejc.lessons/src/resources/homeworks/homework7/file1.txt";
        String fileInputName = "com.epamejc.lessons/src/resources/homeworks/homework7/file2.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             FileWriter fileWriter = new FileWriter(fileInputName)) {
            String s;
            while ((s = reader.readLine()) != null) {
                fileWriter.write(s + "\n");
            }
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Text-stream: " + timeWorkCode);
    }

}
