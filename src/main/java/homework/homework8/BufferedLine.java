package homework.homework8;

import java.io.*;

public class BufferedLine {

    public long measureTime () {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/fileForReading1.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/fileForWriting3.txt"))) {

            String c;

            long startTime = System.nanoTime();

            while ((c = reader.readLine()) != null) {
                writer.write(c);
                writer.newLine();
            }

            long endTime = System.nanoTime();

            return endTime - startTime;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
