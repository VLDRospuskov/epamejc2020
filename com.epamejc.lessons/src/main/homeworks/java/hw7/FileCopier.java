package homeworks.java.hw7;

import java.io.*;

public class FileCopier {

    final String COPY_FROM = "com.epamejc.lessons/src/main/homeworks/java/hw7/hoking.txt";
    final String COPY_TO = "com.epamejc.lessons/src/main/homeworks/java/hw7/NewFile.txt";

    public void run() {
        copySimple();
        copyBuffered();
    }

    private void copySimple() {
        long startTime = System.currentTimeMillis();
        readThenWrite(COPY_FROM, COPY_TO);
        long endTime = System.currentTimeMillis();
        System.out.println("Simple work time in milliseconds: " + (endTime - startTime));
    }

    private void copyBuffered() {
        long startTime = System.currentTimeMillis();
        bufferedReadThenWrite(COPY_FROM, COPY_TO);
        long endTime = System.currentTimeMillis();
        System.out.println("Buffered work time in milliseconds: " + (endTime - startTime));
    }

    private void readThenWrite(String copyFrom, String copyTo) {
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

    private void bufferedReadThenWrite(String copyFrom, String copyTo) {
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
