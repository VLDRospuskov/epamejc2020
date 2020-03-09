package homeworks.homework7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NonBuffered {

    public long measureTime() {

        long startTime = 0;
        long endTime = 0;

        try (FileReader reader = new FileReader("src/main/resources/fileForReading1.txt");
             FileWriter writer = new FileWriter("src/main/resources/fileForWriting2.txt")) {

            int c;

            startTime = System.nanoTime();

            while ((c = reader.read()) != -1) {
                writer.write(c);
            }

            endTime = System.nanoTime();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return endTime - startTime;
    }
}
