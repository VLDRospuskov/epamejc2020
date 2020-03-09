package main.homeworks.homework7;

import lombok.SneakyThrows;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Text {

    @SneakyThrows
    public static void readFile() {
        long start = System.currentTimeMillis();
        String fileName = "com.epamejc.lessons/src/main/homeworks/homework7/text1.txt";
        String fileInputName = "com.epamejc.lessons/src/main/homeworks/homework7/text2.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        FileWriter fileWriter = new FileWriter(fileInputName);
        String s;
        while ((s = reader.readLine()) != null) {
            fileWriter.write(s + "\n");
        }
        reader.close();
        fileWriter.close();
        long timeWorkCode = System.currentTimeMillis() - start;
        System.out.println("Text-stream: " + timeWorkCode);
    }

}
