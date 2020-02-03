package homeworks.homework4.strings.task1;

import java.util.Scanner;

public class EvenOddString {

    private Scanner sc;
    private String inputString;
    private String inputMethod;

    public EvenOddString(Scanner sc) {
        this.sc = sc;
    }

    private void pickMethod() {
        switch (inputMethod) {
            case "even":
                System.out.println(evenString(inputString));
                break;
            case "odd":
                System.out.println((oddString(inputString)));
                break;
            default:
                System.out.println("Unknown method!");
                break;
        }
    }

    private String oddString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    private String evenString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public void run() {
        input();
        pickMethod();
    }

    private void input() {
        System.out.println("Enter string: ");
        inputString = sc.nextLine();
        System.out.println("Enter method: ");
        inputMethod = sc.nextLine();
    }
}
