package com.epamejc.lessons.src.homework.homework7.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomFileGeneratorTest {
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithEmptyName() {
        new RandomFileGenerator("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithZeroNumberLines() {
        new RandomFileGenerator("asdfghj", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithNegativeNumberLInes() {
        new RandomFileGenerator("adsefrgthg", -1);
    }

    @Test
    public void createFile() throws IOException {
        new RandomFileGenerator("large_file", 5).generate();
        File file = new File("large_file");
        assertTrue(file.exists());
        int countLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.readLine() != null) {
                countLines++;
            }
        }
        assertEquals(5, countLines);
        file.delete();
    }


}