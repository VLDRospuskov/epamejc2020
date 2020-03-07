package com.epamejc.lessons.src.homework.homework7.io;

import java.io.*;

public class FileReaderTester {

    private final String name;
    private boolean printOn = true;

    public FileReaderTester(String name) {
        this.name = name;
    }

    public void setPrintOn(boolean printOn) {
        this.printOn = printOn;
    }

    public long readByBufferedReader() throws IOException {
        long startTime = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (printOn) {
                    System.out.println(line);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long readByInputStreamReader() throws IOException {
        long startTime = System.currentTimeMillis();
        try (InputStreamReader inpr = new InputStreamReader(new FileInputStream(name))) {
            int c;
            while ((c = inpr.read()) != -1) {
                if (printOn) {
                    System.out.print((char) c);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
