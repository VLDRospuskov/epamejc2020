package homeworks.HW_7_bufferedReader;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        String fileName = "temp.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Hello there,");
        bufferedWriter.write(" here is some text.");
        bufferedWriter.newLine();
        bufferedWriter.write("We are writing");
        bufferedWriter.write(" the text to the file.");

        bufferedWriter.close();

    }

}
