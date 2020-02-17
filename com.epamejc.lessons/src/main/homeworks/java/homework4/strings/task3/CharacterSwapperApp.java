package main.homeworks.java.homework4.strings.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterSwapperApp {

    private Scanner sc;
    private String inputString;
    private int index1;
    private int index2;

    public CharacterSwapperApp(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        getInput();
        String result = new CharacterSwapper(inputString).swap(index1, index2);
        System.out.println(result);
    }

    private void getInput() {
        System.out.println("Input string: ");
        inputString = sc.nextLine();
        System.out.println("Input char positions to swap (0 - " + (inputString.length() - 1) + "): ");
        try {
            index1 = sc.nextInt();
            index2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
        }
    }
}
