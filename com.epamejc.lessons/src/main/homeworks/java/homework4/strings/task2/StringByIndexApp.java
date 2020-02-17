package main.homeworks.java.homework4.strings.task2;

import java.util.Scanner;

public class StringByIndexApp {

    private Scanner sc;
    private String inputString;

    public StringByIndexApp(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        getInput();
        System.out.println("Enter char position (0 - " + (inputString.length() - 1) + "). " +
                "Exit by entering empty line: ");
        try {
            String result = new StringByIndex(sc, inputString).addLetter();
            System.out.println("New string:" + result);
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    private void getInput() {
        System.out.println("Enter string: ");
        inputString = sc.nextLine();
    }
}
