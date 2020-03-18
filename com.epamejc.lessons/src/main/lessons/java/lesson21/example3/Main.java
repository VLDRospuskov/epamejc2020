package lessons.java.lesson21.example3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        writeIntoFile(new File("file.txt"));
    }

    // InputStream OutputStream - байтовые
    // Writer Reader - символьные
    public static void writeIntoFile(File file) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(file))) {
            w.write("NUMBERS: ");
            w.flush();
            w.write('1');
        } catch (Exception e) {
//            w.write('2');
        } finally {
//            w.write('3');
        }
    }

}
