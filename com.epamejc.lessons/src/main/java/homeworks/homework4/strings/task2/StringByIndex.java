package homeworks.homework4.strings.task2;

import java.util.Scanner;

public class StringByIndex {

    private Scanner sc;
    private String inputString;

    public StringByIndex(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("Enter string: ");
        input();
        System.out.println("Enter char position (0 - " + (inputString.length() - 1) + "). " +
                "Exit by entering empty line: ");
        addLetter();
    }

    private void addLetter() {
        StringBuilder newString = new StringBuilder();
        String inputIndex = sc.nextLine();
        while (!inputIndex.isEmpty()) {
            newString.append(inputString.charAt(Integer.parseInt(inputIndex)));
            System.out.println(newString);
            inputIndex = sc.nextLine();
        }
    }

    private void input() {
        inputString = sc.nextLine();
    }
}
