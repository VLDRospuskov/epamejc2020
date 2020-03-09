package main.homeworks.homework7;

import lombok.SneakyThrows;

import java.io.*;

public class Binary {

    @SneakyThrows
    public static void readFile() {
        long start = System.currentTimeMillis();
        String fileOutputName = "com.epamejc.lessons/src/main/homeworks/homework7/text1.txt";
        String fileInputName = "com.epamejc.lessons/src/main/homeworks/homework7/text2.txt";
        FileOutputStream writer = new FileOutputStream(fileOutputName);
        FileInputStream reader = new FileInputStream(fileInputName);
        int s;
        while ((s = reader.read()) != -1) {
            writer.write(s);
        }
        reader.close();
        writer.close();
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Binary-stream: " + timeWorkCode);
    }

}
