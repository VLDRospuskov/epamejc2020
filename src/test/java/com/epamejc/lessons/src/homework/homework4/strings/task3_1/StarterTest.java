package com.epamejc.lessons.src.homework.homework4.strings.task3_1;

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
    private final String ERR_OPTION_MSG = "Available option \"odd\" or \"even\" . Try again!\n";

    @Test
    public void startErrorOption() {
        String str = "asdf";
        String errOption = "dawda";
        String normalOption = "odd";
        systemInMock.provideLines(str, errOption, normalOption);
        new Starter().start();
        String actualErrOut = systemErrRule.getLog();
        assertEquals(ERR_OPTION_MSG, actualErrOut);
    }

    @Test
    public void startOddOption() {
        String str = "0123456789";
        String option = "odd";
        systemInMock.provideLines(str, option);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] words = out.split("\\n");
        String modifiedString = words[words.length - 1];
        String expectedString = "02468";
        assertEquals(expectedString, modifiedString);
    }

    @Test
    public void startEvenOption() {
        String str = "0123456789";
        String option = "even";
        systemInMock.provideLines(str, option);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] words = out.split("\\n");
        String modifiedString = words[words.length - 1];
        String expectedString = "13579";
        assertEquals(expectedString, modifiedString);
    }
}