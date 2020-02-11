package com.epamejc.lessons.src.homework.homework5.recursion.task4_3;


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
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String NOT_INTEGER_ERR_MSG = "Integer value required. Try again!\n";

    @Test
    public void startNotIntegerNumberArg() {
        String notIntegerValue = "2.3";
        String normalValue = "4";
        systemInMock.provideLines(notIntegerValue, normalValue);
        new Starter().start();
        String actualError = systemErrRule.getLog();
        String expectedError = NOT_INTEGER_ERR_MSG;
        assertEquals(actualError, expectedError);
    }

    @Test
    public void startEmptyArg() {
        String notIntegerValue = "";
        String normalValue = "4";
        systemInMock.provideLines(notIntegerValue, normalValue);
        new Starter().start();
        String actualError = systemErrRule.getLog();
        String expectedError = NOT_INTEGER_ERR_MSG;
        assertEquals(actualError, expectedError);
    }

    @Test
    public void startNegativeValue() {
        String value = "-123456";
        systemInMock.provideLines(value);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "Number of digits: 6";
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startPositiveValue() {
        String value = "123456789";
        systemInMock.provideLines(value);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "Number of digits: 9";
        assertEquals(actualOut, expectedOut);
    }


}