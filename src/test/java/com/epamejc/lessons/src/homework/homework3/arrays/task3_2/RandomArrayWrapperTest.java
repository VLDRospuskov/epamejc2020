package com.epamejc.lessons.src.homework.homework3.arrays.task3_2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RandomArrayWrapperTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestErrorColumnsArgument() {
        int errorColumns = -2;
        int rows = 4;
        new RandomArrayWrapper(errorColumns, rows);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestErrorRowsArgument() {
        int columns = 2;
        int errorRows = -4;
        new RandomArrayWrapper(columns, errorRows);
    }

    @Test
    public void printArrayAStrategy() {
        int columns = 23;
        int rows = 14;
        RandomArrayWrapper ra = new RandomArrayWrapper(columns, rows);
        ra.printArray("A");
        String out = systemOutRule.getLog();
        String[][] arr = Arrays.stream(out.split("\n"))
                .map(e -> Arrays.stream(e.split(" "))
                        .toArray(String[]::new)).toArray(String[][]::new);
        int actualRows = arr.length;
        int expectedRows = rows / 2 + rows % 2;
        assertEquals(actualRows, expectedRows);
        int expectedColumns = columns / 2 + columns % 2;
        for (String[] strings : arr) {
            int actualColumn = strings.length;
            assertEquals(expectedColumns, actualColumn);
        }
    }

    @Test
    public void printArrayBStrategy() {
        int columns = 20;
        int rows = 2;
        RandomArrayWrapper ra = new RandomArrayWrapper(columns, rows);
        ra.printArray("B");
        String out = systemOutRule.getLog();
        String[][] arr = Arrays.stream(out.split("\n"))
                .map(e -> Arrays.stream(e.split(" "))
                        .toArray(String[]::new)).toArray(String[][]::new);
        int actualRows = arr.length;
        int expectedRows = rows / 2 - rows % 2;
        assertEquals(actualRows, expectedRows);
        int expectedColumns = columns / 2 - columns % 2;
        for (String[] strings : arr) {
            int actualColumn = strings.length;
            assertEquals(expectedColumns, actualColumn);
        }
    }

    @Test
    public void printArrayWithoutStrategy() {
        int columns = 20;
        int rows = 2;
        RandomArrayWrapper ra = new RandomArrayWrapper(columns, rows);
        ra.printArray(" ");
        String out = systemOutRule.getLog();
        String[][] arr = Arrays.stream(out.split("\n"))
                .map(e -> Arrays.stream(e.split(" "))
                        .toArray(String[]::new)).toArray(String[][]::new);
        int actualRows = arr.length;
        assertEquals(actualRows, rows);
        for (String[] strings : arr) {
            int actualColumn = strings.length;
            assertEquals(columns, actualColumn);
        }
    }
}