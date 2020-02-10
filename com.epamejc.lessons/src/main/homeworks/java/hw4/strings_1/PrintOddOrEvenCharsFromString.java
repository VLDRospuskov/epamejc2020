package homeworks.java.hw4.strings_1;

import java.util.*;

public class PrintOddOrEvenCharsFromString {

    public void run() {
        String output = buildString(scanString());
        System.out.println("Result: " + output);
    }

    public String[] scanString() {
        Scanner scan = new Scanner(System.in);
        String[] strings = new String[2];

        try {
            System.out.print("Enter string: ");
            strings[0] = scan.nextLine();
            System.out.print("Enter type(even or odd): ");
            strings[1] = scan.next();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        return strings;
    }

    public String buildString(String[] strings) {
        String output = "";

        if (strings[1].equals("even")) {
            for (int i = 1; i < strings[0].length(); i += 2) {
                output += strings[0].charAt(i);
            }
        } else if (strings[1].equals("odd")) {
            for (int i = 0; i < strings[0].length(); i += 2) {
                output += strings[0].charAt(i);
            }
        } else {
            System.out.println("Wrong enter!");
        }
        return output;
    }
}
