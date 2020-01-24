package main.homeworks.strings.task3_1;

import java.util.Scanner;

public class OddEvenSubstring {

    public String useStrategy() {
        System.out.println("Input string to transform");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println("Input \"odd\" or \"even\"");
        String mod = scanner.nextLine().toLowerCase();
        scanner.close();
        switch (mod) {
            case "even":
                return createStringFromEven(inputString);
            case "odd":
                return createStringFromOdd(inputString);
            default:
                System.out.println("wrong mod input");
                return "";
        }
    }

    private String createStringFromOdd(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i += 2) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    private String createStringFromEven(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        if (s.length() > 0) {
            for (int i = 1; i < s.length(); i += 2) {
                stringBuffer.append(s.charAt(i));
            }
        } else {
            System.out.println("String is too short for even");
        }

        return stringBuffer.toString();
    }

}
