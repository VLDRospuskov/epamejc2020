package com.epamejc.lessons.src.homework.homework3.arrays.task2_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StarterTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    private final String NUM_LEVELS_MSG = "Print number of levels:\n";
    private final String ORDER_MSG = "Print order  \"ascending\" or \"descending\" :\n";
    private final String SIDE_MSG = "Print side \"left\" or \"right\" :\n";
    private final String FILL_CHAR_MSG = "Print filling char  :\n";
    private final String ERROR_LEVELS_MSG = "Non-negative integer required. Try again!\n";
    private final String ERROR_SIDE_MSG = "Available side \"left\" or \"right\" . Try again!\n";
    private final String ERROR_ORDER_MSG = "Available order \"ascending\" or \"descending\" . Try again!\n";
    private final String ERROR_CHAR_MSG = "1 symbol expected . Try again!\n";
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void startNegativeNumLevels() {
        String negativeNumLevels = "-1";
        String normalLevels = "2";
        String order = "ascending";
        String side = "right";
        String fillChar = "c";
        systemInMock.provideLines(negativeNumLevels, normalLevels, order, side, fillChar);
        new Starter().start();
        String actualOut = systemErrRule.getLog();
        String expectedOut = ERROR_LEVELS_MSG;
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startWrongSide() {
        String normalLevels = "2";
        String order = "ascending";
        String errorSide = "center";
        String side = "right";
        String fillChar = "c";
        systemInMock.provideLines(normalLevels, order, errorSide, side, fillChar);
        new Starter().start();
        String actualOut = systemErrRule.getLog();
        String expectedOut = ERROR_SIDE_MSG;
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startWrongOrder() {
        String normalLevels = "2";
        String order = "ascending";
        String errorOrder = "ascccending";
        String side = "right";
        String fillChar = "c";
        systemInMock.provideLines(normalLevels, errorOrder, order, side, fillChar);
        new Starter().start();
        String actualOut = systemErrRule.getLog();
        String expectedOut = ERROR_ORDER_MSG;
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startWrongChar() {
        String normalLevels = "2";
        String order = "ascending";
        String side = "right";
        String errorFillChar = "charr";
        String fillChar = "c";
        systemInMock.provideLines(normalLevels, order, side, errorFillChar, fillChar);
        new Starter().start();
        String actualOut = systemErrRule.getLog();
        String expectedOut = ERROR_CHAR_MSG;
        assertEquals(actualOut, expectedOut);
    }
}