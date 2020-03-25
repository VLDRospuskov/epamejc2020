package lessons.java.lesson22.example6;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File file = new File("file.txt");

        new File("C:\\dir1").mkdirs();
        new File("C:\\dir1.1\\dir2\\dir3").mkdir();
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("file2.txt");
            fileWriter.write("34578");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
