package homeworks.homework7;

import java.io.*;

public class Buffered {

    public long measureTime () {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/fileForReading1.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/fileForWriting1.txt"))) {

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
