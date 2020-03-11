package homeworks.homework7;

import java.io.*;

public class BufferedLine {

    public long measureTime () {

        long startTime = 0;
        long endTime = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/fileForReading1.txt"));
             BufferedWriter writer = new BufferedWriter(
                     new FileWriter("src/main/resources/fileForWriting3.txt"))) {

            String c;

            startTime = System.nanoTime();

            while ((c = reader.readLine()) != null) {
                writer.write(c);
                writer.newLine();
            }

            endTime = System.nanoTime();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return endTime - startTime;
    }
}
