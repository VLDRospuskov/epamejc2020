package Homeworks.HW7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WithFileReaderWriter {

    FileReader fileReader = null;
    FileWriter fileWriter = null;

    public void run() {
        try {
            fileReader = new FileReader("lorem.txt");
            fileWriter = new FileWriter("out.txt");
            while (fileReader.ready()) {
                int data = fileReader.read();
                fileWriter.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null && fileWriter != null) {
                try {
                    fileWriter.close();
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
