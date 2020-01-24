package main.homeworks.hw2.strings_3_1;

import java.util.*;

public class StringOddEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "";
        String type = "";

        try {
            System.out.print("Enter string: ");
            str = scan.next();
            System.out.print("Enter type(even or odd): ");
            type = scan.next();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        String output = "";

        if (type.equals("even")) {
            for (int i = 1; i < str.length(); i += 2) {
                output += str.charAt(i);
            }
        } else if (type.equals("odd")) {
            for (int i = 0; i < str.length(); i += 2) {
                output += str.charAt(i);
            }
        } else {
            System.out.println("Wrong enter!");
        }

        System.out.println(output);
    }
}
