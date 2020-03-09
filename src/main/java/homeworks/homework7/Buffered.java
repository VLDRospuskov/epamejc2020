package homeworks.homework7;

import java.io.*;

public class Buffered {

    public long measureTime () {

        long startTime = 0;
        long endTime = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/fileForReading1.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/fileForWriting1.txt"))) {

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
