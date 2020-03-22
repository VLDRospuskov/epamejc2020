package main.homeworks.hw4;

import java.util.Scanner;

public class StringFromInput {

    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input string: ");
        String inString = in.nextLine();

        return inString;
    }
}
