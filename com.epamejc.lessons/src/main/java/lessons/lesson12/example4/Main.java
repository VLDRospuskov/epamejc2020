package lessons.lesson12.example4;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    
    public static void main(String[] args) {
        readFile();
    }
    
    @SneakyThrows
    private static void readFile() {
        BufferedReader reader = new BufferedReader(new FileReader("my_text.txt"));
        String s = reader.readLine();
        System.out.println(s);
    }
    
    @SneakyThrows
    private static void writeIntoFile() {
        FileWriter fileWriter = new FileWriter("my_text.txt");
        fileWriter.write("Hello world");
        fileWriter.flush();
    }
    
}
