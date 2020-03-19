package homeworks.java.hw7;

import java.io.*;

public class FileCopier {

    private final String COPY_FROM = "com.epamejc.lessons/src/main/homeworks/java/hw7/Text.txt";
    private final String COPY_TO = "com.epamejc.lessons/src/main/homeworks/java/hw7/TextCopy.txt";

    public void run() {
        measureSimpleCopy();
        measureBufferedCopy();
    }

    private void measureSimpleCopy() {
        long startTime = System.currentTimeMillis();
        simpleCopy(COPY_FROM, COPY_TO);
        long endTime = System.currentTimeMillis();
        System.out.println("Simple copy work time: " + (endTime - startTime) + " ms");
    }

    private void measureBufferedCopy() {
        long startTime = System.currentTimeMillis();
        bufferedCopy(COPY_FROM, COPY_TO);
        long endTime = System.currentTimeMillis();
        System.out.println("Buffered copy work time: " + (endTime - startTime) + " ms");
    }

    private void simpleCopy(String copyFrom, String copyTo) {
        char[] textBuffer = new char[256];

        try(FileReader fr = new FileReader(copyFrom);
            FileWriter fw = new FileWriter(copyTo)) {
            while (fr.read(textBuffer) != -1) {
                fw.write(textBuffer);
            }
        } catch (IOException e) {
            System.err.println("Read/Write error! " + e);
        }
    }

    private void bufferedCopy(String copyFrom, String copyTo) {
        char[] textBuffer = new char[256];

        try(BufferedReader br = new BufferedReader(new FileReader(copyFrom));
            BufferedWriter bw = new BufferedWriter(new FileWriter(copyTo))) {
            while (br.read(textBuffer) != -1) {
                bw.write(textBuffer);
            }
        } catch (IOException e) {
            System.err.println("Read/Write error! " + e);
        }
    }

}
