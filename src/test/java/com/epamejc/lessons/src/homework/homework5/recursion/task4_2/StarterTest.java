package com.epamejc.lessons.src.homework.homework5.recursion.task4_2;

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
        String normalValue = "2";
        String normalPower = "1";
        systemInMock.provideLines(notIntegerValue, normalValue, normalPower);
        new Starter().start();
        String actualError = systemErrRule.getLog();
        assertEquals(actualError, NOT_INTEGER_ERR_MSG);
    }

    @Test
    public void startNotIntegerPowerArg() {
        String notIntegerValue = "1.322";
        String normalValue = "2";
        String normalPower = "1";
        systemInMock.provideLines(normalValue, notIntegerValue, normalPower);
        new Starter().start();
        String actualError = systemErrRule.getLog();
        assertEquals(actualError, NOT_INTEGER_ERR_MSG);
    }

    @Test
    public void startZeroPower() {
        String value = "2";
        String power = "0";
        systemInMock.provideLines(value, power);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "2^(0) =1.0";
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startNegativePower() {
        String value = "2";
        String negativePower = "-5";
        systemInMock.provideLines(value, negativePower);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "2^(-5) =0.03125";
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startNegativeValue() {
        String negativeValue = "-2";
        String power = "5";
        systemInMock.provideLines(negativeValue, power);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "-2^(5) =-32.0";
        assertEquals(actualOut, expectedOut);
    }


}