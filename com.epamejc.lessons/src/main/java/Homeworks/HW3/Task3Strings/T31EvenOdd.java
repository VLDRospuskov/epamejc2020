package Homeworks.HW3.Task3Strings;

import java.util.Scanner;

public class T31EvenOdd {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String eo = scanner.nextLine();

        String output = "";

        switch (eo) {
            case "even":
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 == 0) {
                        output = output + input.charAt(i);
                    }
                }
                break;

            case "odd":
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 != 0) {
                        output = output + input.charAt(i);
                    }
                }
                break;

            default:
                System.out.println("Please input \"even\" or \"odd\" value");
                return;
        }

        System.out.println(output);
    }
}
