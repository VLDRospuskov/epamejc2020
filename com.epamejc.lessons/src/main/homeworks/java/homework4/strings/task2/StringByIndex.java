package main.homeworks.java.homework4.strings.task2;

import java.util.Scanner;

public class StringByIndex {

    private Scanner sc;
    private String inputString;

    public StringByIndex(Scanner sc, String inputString) {
        this.sc = sc;
        this.inputString = inputString;
    }

    public String addLetter() {
        StringBuilder newString = new StringBuilder();
        String inputIndex = sc.nextLine();
        while (!inputIndex.isEmpty()) {
            newString.append(inputString.charAt(Integer.parseInt(inputIndex)));
            System.out.println(newString);
            inputIndex = sc.nextLine();
        }
        return newString.toString();
    }


}
