package main.homeworks.java.homework4.strings.task1;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private String inputString;
    private String inputMethod;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        getInput();
        String result = new EvenOddString(inputString).makeString(inputMethod);
        System.out.println(result);
    }

    private void getInput() {
        System.out.println("Enter string: ");
        inputString = sc.nextLine();
        System.out.println("Enter method: ");
        inputMethod = sc.nextLine();
    }
}
