package main.Homeworks.HW3.Task3Strings;

import java.util.Scanner;

public class T34Reverse {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.contains(" ")) {
            // split
            String[] inputArr = input.split(" ");
            for (String s : inputArr) {
                System.out.print(reversed(s) + " ");
            }
        } else {
            // reverse one
            System.out.println(reversed(input));
        }
    }

    private String reversed(String str) {
        String res = "";
        for (int i = str.length()-1; i >= 0; i--) {
            res = res + str.charAt(i);
        }
        return res;
    }
}
