package main.homeworks.java.homework4.strings.task4;

import java.util.Scanner;

public class WordReverserApp {

    private Scanner sc;
    private String inputString;

    public WordReverserApp(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        getInput();
        String result = new WordReverser(inputString).reverse();
        System.out.println(result);
    }

    private void getInput() {
        System.out.println("Input string: ");
        inputString = sc.nextLine();
    }
}
