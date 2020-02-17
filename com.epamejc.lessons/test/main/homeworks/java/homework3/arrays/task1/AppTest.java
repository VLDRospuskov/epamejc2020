package main.homeworks.java.homework3.arrays.task1;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AppTest {

    private App app;

    @Test
    public void TestRunSuccess() {
        String input1 = "3 7";
        app = new App(new Scanner(input1));
        app.run();
    }

    @Test(expected = InputMismatchException.class)
    public void TestRunFail() {
        String input2 = "three seven";
        app = new App(new Scanner(input2));
        app.run();
    }
}