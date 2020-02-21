package Homeworks.HW7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WithFileReaderWriter {

    public void run() {
        try {
            FileReader fileReader = new FileReader("lorem.txt");
            FileWriter fileWriter = new FileWriter("out.txt");
            while (fileReader.ready()) {
                int data = fileReader.read();
                fileWriter.write(data);
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
