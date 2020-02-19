package homeworks.java.hw7;

import lombok.SneakyThrows;

import java.io.*;
import java.sql.Timestamp;

public class BufferedFileCopy {

    public void run() {
        copyFile();
    }

    @SneakyThrows
    private void copyFile() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long startTime = timestamp.getTime();

        char[] text = new char[256];
        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new FileReader("com.epamejc.lessons/src/main/homeworks/java/hw7/hoking.txt"));
            fw = new FileWriter("com.epamejc.lessons/src/main/homeworks/java/hw7/NewFile.txt");
            while (br.read(text) != -1) {
                fw.write(text);
            }
        } catch (IOException e) {
            System.err.println("Read or write error! =)");
        } finally {
            if (br != null) {
                br.close();
            }
            if (fw != null) {
                fw.close();
            }

        }

        timestamp = new Timestamp(System.currentTimeMillis());
        long endTime = timestamp.getTime();
        System.out.println("Buffered work time in mls: " + (endTime - startTime));
    }
}
