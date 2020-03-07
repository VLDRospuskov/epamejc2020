package com.epamejc.lessons.src.homework.homework7.io;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileReaderTesterTest {
    static String name = "test_file";
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();

    @BeforeClass
    public static void generateTestFile() throws IOException {
        new RandomFileGenerator(name, 1000).generate();
    }

    @AfterClass
    public static void deleteTestFile() {
        File file = new File(name);
        file.delete();
    }

    @Test
    public void setPrintOnEmptyOut() throws IOException {
        FileReaderTester frt = new FileReaderTester(name);
        frt.setPrintOn(false);
        frt.readByInputStreamReader();
        assertTrue(systemOutRule.getLog().isEmpty());
    }

    @Test
    public void setPrintOnNotEmptyOut() throws IOException {
        FileReaderTester frt = new FileReaderTester(name);
        frt.setPrintOn(true);
        frt.readByInputStreamReader();
        assertFalse(systemOutRule.getLog().isEmpty());
    }

    @Test
    public void assertInputStreamReaderTimeNotZero() throws IOException {
        FileReaderTester frt = new FileReaderTester(name);
        frt.setPrintOn(false);
        long time = frt.readByInputStreamReader();
        assertTrue(time > 0);
    }

    @Test
    public void assertBufferedReaderTimeNotZero() throws IOException {
        FileReaderTester frt = new FileReaderTester(name);
        frt.setPrintOn(false);
        long time = frt.readByBufferedReader();
        assertTrue(time > 0);
    }

}