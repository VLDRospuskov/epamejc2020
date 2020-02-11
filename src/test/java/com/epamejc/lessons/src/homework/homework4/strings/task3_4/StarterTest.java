package com.epamejc.lessons.src.homework.homework4.strings.task3_4;

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

    @Test
    public void startEmptyFirstString() {
        String str = "";
        systemInMock.provideLines(str);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "Output: ";
        assertEquals(actualOut, expectedOut);
    }

    @Test
    public void startReverseWord() {
        String str = "123 345";
        systemInMock.provideLines(str);
        new Starter().start();
        String out = systemOutRule.getLog();
        String[] lines = out.split("\\n");
        String actualOut = lines[lines.length - 1];
        String expectedOut = "Output: 321 543";
        assertEquals(actualOut, expectedOut);
    }

}