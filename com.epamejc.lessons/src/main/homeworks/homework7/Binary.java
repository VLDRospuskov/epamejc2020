package main.homeworks.homework7;

import lombok.SneakyThrows;

import java.io.*;

public class Binary {

    @SneakyThrows
    public static void readFile() {
        long start = System.currentTimeMillis();
        String fileOutputName = "com.epamejc.lessons/src/resources/homeworks/homework7/file1.txt";
        String fileInputName = "com.epamejc.lessons/src/resources/homeworks/homework7/file2.txt";
        try (FileOutputStream writer = new FileOutputStream(fileOutputName);
             FileInputStream reader = new FileInputStream(fileInputName)) {
            int s;
            while ((s = reader.read()) != -1) {
                writer.write(s);
            }
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Binary-stream: " + timeWorkCode);
    }

}
