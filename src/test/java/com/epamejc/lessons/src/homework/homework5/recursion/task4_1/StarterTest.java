package com.epamejc.lessons.src.homework.homework5.recursion.task4_1;

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
    private final String ERR_ARG_MSG = "Non-negative integer required. Try again!\n";

    @Test
    public void startNotIntegerArg() {
        String notIntegerValue = "asdf";
        String normalValue = "5";
        systemInMock.provideLines(notIntegerValue, normalValue);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = ERR_ARG_MSG;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startNegativeIntegerArg() {
        String negativeIntegerValue = "-1";
        String normalValue = "5";
        systemInMock.provideLines(negativeIntegerValue, normalValue);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        String expectedErrOut = ERR_ARG_MSG;
        assertEquals(expectedErrOut, actualErrOut);
    }

    @Test
    public void startZeroFibonacci() {
        String value = "0";
        systemInMock.provideLines(value);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "Done.";
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void startOneFibonacci() {
        String value = "1";
        systemInMock.provideLines(value);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "0 Done.";
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void start10Fibonacci() {
        String value = "10";
        systemInMock.provideLines(value);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "0 1 1 2 3 5 8 13 21 34 Done.";
        assertEquals(expectedOut, actualOut);
    }

}