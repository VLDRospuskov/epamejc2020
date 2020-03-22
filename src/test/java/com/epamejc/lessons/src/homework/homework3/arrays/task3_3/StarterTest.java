package com.epamejc.lessons.src.homework.homework3.arrays.task3_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StarterTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    private final String ERROR_LEVELS_MSG = "Non-negative integer required. Try again!\n";
    private final String ERROR_SIDE_MSG = "Available side \"left\" or \"right\" . Try again!\n";
    private final String ERROR_ORDER_MSG = "Available order \"ascending\" or \"descending\" . Try again!\n";
    private final String ERROR_CHAR_MSG = "1 symbol expected . Try again!\n";

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
        assertEquals(ERROR_LEVELS_MSG, actualOut);
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
        assertEquals(ERROR_SIDE_MSG, actualOut);
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
        assertEquals(actualOut, ERROR_ORDER_MSG);
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
        assertEquals(ERROR_CHAR_MSG, actualOut);
    }
}