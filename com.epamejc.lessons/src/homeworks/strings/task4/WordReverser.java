package homeworks.strings.task4;

import java.util.Scanner;

public class WordReverser {

    private Scanner sc;
    private String inputString;

    public WordReverser(Scanner sc) {
        this.sc = sc;
    }

    private String reverse() {
        String[] input = inputString.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : input) {
            s = new StringBuilder(s).reverse().toString();
            result.append(s).append(" ");
        }
        return result.toString();
    }

    public void run() {
        input();
        System.out.println(reverse());
    }

    private void input() {
        System.out.println("Input string: ");
        inputString = sc.nextLine();
    }
}
