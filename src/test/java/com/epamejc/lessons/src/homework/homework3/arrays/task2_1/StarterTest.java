package com.epamejc.lessons.src.homework.homework3.arrays.task2_1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StarterTest {
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String ERROR_MSG = "Non-negative integer required. Try again!\n";


    @Test
    public void startErrorStringValueRows() {
        String errRows = "non-integer";
        String rows = "4";
        String columns = "2";
        systemInMock.provideLines(errRows, rows, columns);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        assertEquals(ERROR_MSG, actualErrorOut);
    }

    @Test
    public void startErrorStringValueColumns() {
        String errColumns = "non-integer";
        String rows = "2";
        String columns = "42";
        systemInMock.provideLines(rows, errColumns, columns);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        assertEquals(ERROR_MSG, actualErrorOut);
    }

    @Test
    public void startNegativeIntValueRows() {
        String errRows = "-200";
        String rows = "4";
        String columns = "2";
        systemInMock.provideLines(errRows, rows, columns);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        assertEquals(ERROR_MSG, actualErrorOut);
    }

    @Test
    public void startNegativeIntValueColumns() {
        String errColumns = "-666";
        String rows = "2";
        String columns = "42";
        systemInMock.provideLines(rows, errColumns, columns);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        assertEquals(ERROR_MSG, actualErrorOut);
    }
}