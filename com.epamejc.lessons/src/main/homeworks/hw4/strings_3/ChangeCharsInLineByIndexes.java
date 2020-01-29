package main.homeworks.hw4.strings_3;

import java.util.*;

public class ChangeCharsInLineByIndexes {

    public void run() {
        String str = scanInputString();
        int len = str.length() - 1;
        int[] i = scanIndexes(len);
        printLine(i, str, len);
    }

    public String scanInputString() {
        Scanner scan = new Scanner(System.in);
        String str = "";

        try {

            System.out.print("Please enter text: ");
            str = scan.nextLine();

        } catch (Exception e) {
            System.out.println("Error! " + e);
        }

        return str;
    }

    public int[] scanIndexes(int len) {
        Scanner scan2 = new Scanner(System.in);
        int indexes[] = new int[2];

        try {
            System.out.print("Please enter two indexes to change (between 0 and " + len + "): ");
            indexes[0] = scan2.nextInt();
            indexes[1] = scan2.nextInt();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan2.close();
        }

        return indexes;
    }

    public String buildString(int[] i, String str) {
        String output = "";
        String left = str.substring(0, i[0]) + str.charAt(i[1]);
        String middle = str.substring(i[0] + 1, i[1]) + str.charAt(i[0]);
        String right = str.substring(i[1] + 1);
        output = left + middle + right;

        return output;
    }

    public void printLine(int[] i, String str, int len) {

        if (i[0] < 0 || i[0] > len || i[1] < 0 || i[1] > len || i[0] == i[1]) {
            System.out.println("Wrong enter!");
        } else {
            if (i[0] > i[1]) {
                int tmp = i[0];
                i[0] = i[1];
                i[1] = tmp;
            }
            System.out.println("Result: " + buildString(i, str));
        }
    }

}
