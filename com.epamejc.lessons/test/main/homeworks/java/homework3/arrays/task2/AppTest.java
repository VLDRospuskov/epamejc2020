package main.homeworks.java.homework3.arrays.task2;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class AppTest {
    private App app;

    @Test
    public void TestRunSuccess() {
        String input1 = "3 7 \nA";
        app = new App(new Scanner(input1));
        app.run();
    }

    @Test(expected = InputMismatchException.class)
    public void TestRunFail() {
        String input2 = "three seven \nA";
        app = new App(new Scanner(input2));
        app.run();
    }
}