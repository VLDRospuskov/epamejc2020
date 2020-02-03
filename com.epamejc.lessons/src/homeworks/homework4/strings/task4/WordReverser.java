package homeworks.homework4.strings.task4;

import java.util.Scanner;

public class WordReverser {

    private Scanner sc;
    private String inputString;

    public WordReverser(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        input();
        System.out.println(reverse());
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

    private void input() {
        System.out.println("Input string: ");
        inputString = sc.nextLine();
    }
}
