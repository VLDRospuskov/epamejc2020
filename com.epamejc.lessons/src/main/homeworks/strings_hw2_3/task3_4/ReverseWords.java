package main.homeworks.strings_hw2_3.task3_4;

import java.util.Scanner;

public class ReverseWords {


    public void getReversedString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input source string");
        String inputString = scanner.nextLine();
        scanner.close();
        System.out.println(run(inputString));
    }

    private String run(String inputString) {
        Scanner subScanner = new Scanner(inputString).useDelimiter("\\s* \\s*");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        while (subScanner.hasNext()) {
            reverse.append(subScanner.next());
            stringBuilder.append(reverse.reverse()).append(" ");
            reverse.delete(0, reverse.length());
        }
        subScanner.close();

        return stringBuilder.toString();
    }
}
