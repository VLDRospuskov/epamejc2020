package homeworks.strings.task2;

import java.util.Scanner;

public class StringByIndex {

    private Scanner sc;
    private String inputString;

    public StringByIndex(Scanner sc) {
        this.sc = sc;
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

    public void run() {
        System.out.println("Enter string: ");
        input();
        System.out.println("Enter char position (0 - " + (inputString.length() - 1) + "). " +
                "Exit by entering empty line: ");
        addLetter();
    }

    private void input() {
        inputString = sc.nextLine();
    }
}
