package com.epamejc.lessons.src.homework.homework1.trafficlight;


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
    private final String FIRST_MSG = "Print integer value between 0 and 10 to change color of traffic light or 'exit' to close the program\n";
    private final String EXIT_MSG = "Bye-bye!\n";
    private final String COLOR_CHANGE_MSG = "Traffic Light : ";
    private final String ERROR_INT_VALUE_MSG = "Wrong Input!An integer value between 0 and 10 is required!\n";
    private final String ERROR_STRING_VALUE_MSG = "Wrong Input!For input string: ";
    private final String EXIT = "exit\n";

    @Test
    public void startExit() {
        systemInMock.provideLines(EXIT);
        new Starter().start();
        String actualOut = systemOutRule.getLog();
        String expectedOut = FIRST_MSG + EXIT_MSG;
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void startChangeColorAllCorrect() {
        String redColor = "10";
        String yellowColor = "5";
        systemInMock.provideLines(redColor, yellowColor, EXIT);
        new Starter().start();
        String actualOut = systemOutRule.getLog();
        String expectedOut = FIRST_MSG + COLOR_CHANGE_MSG + "RED\n" + COLOR_CHANGE_MSG + "YELLOW\n" + EXIT_MSG;
        assertEquals(expectedOut, actualOut);
    }

    @Test
    public void startChangeColorWithErrorIntValue() {
        String errorColor = "-2";
        String yellowColor = "5";
        systemInMock.provideLines(errorColor, yellowColor, EXIT);
        new Starter().start();
        String actualOut = systemOutRule.getLog();
        String expectedOut = FIRST_MSG + COLOR_CHANGE_MSG + "YELLOW\n" + EXIT_MSG;
        assertEquals(actualOut, expectedOut);
        String actualErrorOut = systemErrRule.getLog();
        assertEquals(ERROR_INT_VALUE_MSG, actualErrorOut);
    }

    @Test
    public void startChangeColorWithErrorStringValue() {
        String errorString = "tampamdam";
        systemInMock.provideLines(errorString, EXIT);
        new Starter().start();
        String actualOut = systemOutRule.getLog();
        String expectedOut = FIRST_MSG + EXIT_MSG;
        assertEquals(actualOut, expectedOut);
        String actualErrorOut = systemErrRule.getLog();
        String expectedErrorOut = ERROR_STRING_VALUE_MSG + "\"" + errorString + "\"" + "\n";
        assertEquals(expectedErrorOut, actualErrorOut);
    }
}