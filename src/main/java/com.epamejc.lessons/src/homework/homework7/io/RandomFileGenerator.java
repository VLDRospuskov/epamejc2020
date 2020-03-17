package com.epamejc.lessons.src.homework.homework7.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class RandomFileGenerator {
    private String name;
    private int numberLines;

    RandomFileGenerator(String name, int numberLines) {
        if (numberLines <= 0) {
            throw new IllegalArgumentException("Number of lines should be the positive integer.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name of file should not be empty");
        }
        this.name = name;
        this.numberLines = numberLines;
    }

    public void generate() throws IOException {
        File file = new File(name);
        Files.deleteIfExists(file.toPath());
        file.createNewFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < numberLines; i++) {
                String randomLine = generateRandomLineOfLength(10000);
                bufferedWriter.write(randomLine + "\n");
            }
        }
    }

    private String generateRandomLineOfLength(int length) {
        int leftLimit = '0';
        int rightLimit = 'z';
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= '9' || i >= 'A') && (i <= 'Z' || i >= 'a'))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
