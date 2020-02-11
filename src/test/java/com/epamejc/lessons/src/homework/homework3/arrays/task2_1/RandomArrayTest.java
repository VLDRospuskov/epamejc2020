package com.epamejc.lessons.src.homework.homework3.arrays.task2_1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RandomArrayTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestErrorColumnsArgument() {
        int errorColumns = -2;
        int rows = 4;
        new RandomArray(rows, errorColumns);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestErrorRowsArgument() {
        int columns = 2;
        int errorRows = -4;
        new RandomArray(columns, errorRows);
    }

    @Test
    public void printArray() {
        int columns = 20;
        int rows = 2;
        RandomArray ra = new RandomArray(columns, rows);
        ra.printArray();
        String out = systemOutRule.getLog();
        String[][] arr = Arrays.stream(out.split("\n"))
                .map(e -> Arrays.stream(e.split(" "))
                        .toArray(String[]::new)).toArray(String[][]::new);
        int actualRows = arr.length;
        assertEquals(actualRows, rows);
        for (int i = 0; i < arr.length; i++) {
            int actualColumn = arr[i].length;
            assertEquals(columns, actualColumn);
        }
    }
}