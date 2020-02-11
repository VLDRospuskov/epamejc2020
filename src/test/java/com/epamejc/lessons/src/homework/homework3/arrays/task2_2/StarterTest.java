package com.epamejc.lessons.src.homework.homework3.arrays.task2_2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class StarterTest {
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
    private final String ERROR_NUMBERS_MSG = "Non-negative integer required. Try again!\n";
    private final String ERROR_STRATEGY_MSG = "Available strategy \"A\" or \"B\" . Try again!\n";
    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void startErrorStringValueRows() {
        String errRows = "non-integer";
        String rows = "4";
        String columns = "2";
        String strategy = "A";
        systemInMock.provideLines(errRows, rows, columns, strategy);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_NUMBERS_MSG;
        assertEquals(expectedErrorOut, actualErrorOut);
    }

    @Test
    public void startErrorStringValueColumns() {
        String errColumns = "non-integer";
        String rows = "2";
        String columns = "42";
        String strategy = "A";
        systemInMock.provideLines(rows, errColumns, columns, strategy);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_NUMBERS_MSG;
        assertEquals(expectedErrorOut, actualErrorOut);
    }

    @Test
    public void startNegativeIntValueRows() {
        String errRows = "-200";
        String rows = "4";
        String columns = "2";
        String strategy = "A";
        systemInMock.provideLines(errRows, rows, columns, strategy);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_NUMBERS_MSG;
        assertEquals(expectedErrorOut, actualErrorOut);
    }

    @Test
    public void startNegativeIntValueColumns() {
        String errColumns = "-666";
        String rows = "2";
        String columns = "42";
        String strategy = "A";
        systemInMock.provideLines(rows, errColumns, columns, strategy);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_NUMBERS_MSG;
        assertEquals(expectedErrorOut, actualErrorOut);
    }

    @Test
    public void startErrorValueStrategy() {
        String rows = "2";
        String columns = "42";
        String errStrategy = "not a strategy";
        String strategy = "b";
        systemInMock.provideLines(rows, columns, errStrategy, strategy);
        new Starter().start();
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_STRATEGY_MSG;
        assertEquals(expectedErrorOut, actualErrorOut);
    }


}