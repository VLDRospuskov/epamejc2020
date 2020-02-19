package homework.homework8;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NonBuffered {

    public long measureTime() {

        try (FileReader reader = new FileReader("src/main/resources/fileForReading1.txt");
             FileWriter writer = new FileWriter("src/main/resources/fileForWriting2.txt")) {

            int c;

            long startTime = System.nanoTime();

            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

            long endTime = System.nanoTime();

            return endTime - startTime;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
