package com.epamejc.lessons.src.homework.homework4.strings.task3_2;

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
    private final String ERR_ARG_MSG = "Wrong Input! Non-negative integer value expected or \"exit\".\n";
    private final String ERR_POSITION = "Parent string does not have this position.Try again!\n";
    private final String EMPTY_FIRST_STRING = "String must be not empty! Try again.\n";
    private final String EXIT = "exit";
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void startNotIntegerArgument() {
        String str = "dasdf";
        String errorArg = "adw";
        systemInMock.provideLines(str, errorArg, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = ERR_ARG_MSG;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startNegativePosition() {
        String str = "dasdf";
        String negativePosition = "-1";
        systemInMock.provideLines(str, negativePosition, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = ERR_POSITION;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startPositionOutOfBounds() {
        String str = "aaa";
        String outOfBoundsPosition = "4";
        systemInMock.provideLines(str, outOfBoundsPosition, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = ERR_POSITION;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startEmptyFirstString() {
        String str = "";
        String normalStr = "awd";
        systemInMock.provideLines(str, normalStr, EXIT);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = EMPTY_FIRST_STRING;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startCheckModifiedString() {
        String str = "012345678";
        String position1 = "0";
        String position2 = "4";
        String position3 = "2";
        systemInMock.provideLines(str, position1, position2, position3, EXIT);
        new Starter().start();
        String out = systemOutRule.getLog();
        String lines[] = out.split("\\n");
        String modifiedString = lines[lines.length - 2];
        assertTrue(modifiedString.endsWith("Output:042"));
    }


}