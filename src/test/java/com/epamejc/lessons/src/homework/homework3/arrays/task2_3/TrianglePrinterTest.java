package com.epamejc.lessons.src.homework.homework3.arrays.task2_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class TrianglePrinterTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test(expected = IllegalArgumentException.class)
    public void printTriangleNegativeLevels() {
        int negativeLevels = -1;
        String order = "ascending";
        String side = "left";
        new TrianglePrinter('=').printTriangle(negativeLevels, order, side);
    }

    @Test
    public void printTriangleZeroLevels() {
        int zeroLevels = 0;
        String order = "ascending";
        String side = "left";
        new TrianglePrinter('=').printTriangle(zeroLevels, order, side);
        String expectedOut = "\n";
        String actualOut = systemOutRule.getLog();
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void printTriangleLeftAscending() {
        int zeroLevels = 3;
        String order = "ascending";
        String side = "left";
        char fill = 'f';
        new TrianglePrinter(fill).printTriangle(zeroLevels, order, side);
        String expectedOut = "\n" + fill + "\n" + fill + fill + "\n" + fill + fill + fill + "\n";
        String actualOut = systemOutRule.getLog();
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void printTriangleRightAscending() {
        int zeroLevels = 3;
        String order = "ascending";
        String side = "right";
        char fill = 'f';
        new TrianglePrinter(fill).printTriangle(zeroLevels, order, side);
        String expectedOut = "   \n   " + fill + "\n   " + fill + fill + "\n   " + fill + fill + fill + "\n";
        String actualOut = systemOutRule.getLog();
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void printTriangleLeftDescending() {
        int zeroLevels = 3;
        String order = "descending";
        String side = "left";
        char fill = 'a';
        new TrianglePrinter(fill).printTriangle(zeroLevels, order, side);
        String expectedOut = "" + fill + fill + fill + "\n" + fill + fill + "\n" + fill + "\n\n";
        String actualOut = systemOutRule.getLog();
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void printTriangleRightDescending() {
        int zeroLevels = 3;
        String order = "descending";
        String side = "right";
        char fill = 'a';
        new TrianglePrinter(fill).printTriangle(zeroLevels, order, side);
        String expectedOut = "" + fill + fill + fill + "\n " + fill + fill + "\n  " + fill + "\n   \n";
        String actualOut = systemOutRule.getLog();
        assertEquals(expectedOut, actualOut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printTriangleErrorOrder() {
        int negativeLevels = 2;
        String order = "error value";
        String side = "left";
        new TrianglePrinter('=').printTriangle(negativeLevels, order, side);
    }

    @Test(expected = IllegalArgumentException.class)
    public void printTriangleErrorSide() {
        int negativeLevels = 6;
        String order = "ascending";
        String side = "error side";
        new TrianglePrinter('=').printTriangle(negativeLevels, order, side);
    }

}