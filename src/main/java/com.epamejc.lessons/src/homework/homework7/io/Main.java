package com.epamejc.lessons.src.homework.homework7.io;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new RandomFileGenerator("big_file", 1000).generate();
            FileReaderTester frt = new FileReaderTester("big_file");
            frt.setPrintOn(false);
            long bufTime = frt.readByBufferedReader();
            System.out.println("BufferedReader time : " + bufTime);
            long inStreamTime = frt.readByInputStreamReader();
            System.out.println("InputStreamReader time : " + inStreamTime);
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }
}
