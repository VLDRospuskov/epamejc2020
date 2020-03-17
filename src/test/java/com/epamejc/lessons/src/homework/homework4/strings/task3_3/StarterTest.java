package com.epamejc.lessons.src.homework.homework4.strings.task3_3;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StarterTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String EMPTY_FIRST_STRING = "String must be not empty! Try again.\n";
    private final String ERR_ARG_MSG = "Wrong Input! Two comma separated non-negative integer values expected or \"exit\".\n";
    private final String ERR_NUM_ARG_MSG = "Invalid parameters number.Try again!\n";
    private final String ERR_POSITION_MSG = "Parent string does not have this position.Try again!\n";
    private final String EXIT = "exit";

    @Test
    public void startWrongNumberOfArgument() {
        String str = "dasdf";
        String errorArg = "adsfgd";
        systemInMock.provideLines(str, errorArg, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        assertEquals(ERR_NUM_ARG_MSG, actualErrOut);
    }

    @Test
    public void startNotIntegerArguments() {
        String str = "dasdf";
        String errorArg = "adsfgd, dsfgh";
        systemInMock.provideLines(str, errorArg, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        assertEquals(ERR_ARG_MSG, actualErrOut);
    }

    @Test
    public void startOutOfBoundsArguments() {
        String str = "0123456";
        String outOfBoundArg = "8, 9";
        systemInMock.provideLines(str, outOfBoundArg, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        assertEquals(ERR_POSITION_MSG, actualErrOut);
    }

    @Test
    public void startEmptyFirstString() {
        String str = "";
        String normalStr = "awdasdfg";
        systemInMock.provideLines(str, normalStr, EXIT);
        new com.epamejc.lessons.src.homework.homework4.strings.task3_2.Starter().start();
        String actualErrOut = systemErrRule.getLog();
        assertEquals(EMPTY_FIRST_STRING, actualErrOut);
    }

    @Test
    public void startModifiedString() {
        String str = "0123456";
        String firstPosition = "0, 1";
        String secondPosition = "3, 4";
        systemInMock.provideLines(str, firstPosition, secondPosition, EXIT);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String lastModifiedString = lines[lines.length - 2];
        assertTrue(lastModifiedString.endsWith("Output: 1024356"));
    }

}