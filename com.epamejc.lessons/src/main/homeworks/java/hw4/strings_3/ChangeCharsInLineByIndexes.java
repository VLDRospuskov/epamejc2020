package homeworks.java.hw4.strings_3;

import java.util.*;

public class ChangeCharsInLineByIndexes {

    public void run() {
        String str = scanInputString();
        int len = str.length() - 1;
        int[] indexes = scanIndexes(len);
        printLine(indexes, str, len);
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

    public String buildString(int[] indexes, String str) {
        String output = "";
        String left = str.substring(0, indexes[0]) + str.charAt(indexes[1]);
        String middle = str.substring(indexes[0] + 1, indexes[1]) + str.charAt(indexes[0]);
        String right = str.substring(indexes[1] + 1);
        output = left + middle + right;

        return output;
    }

    public void printLine(int[] indexes, String str, int len) {

        if (indexes[0] < 0 || indexes[0] > len
                || indexes[1] < 0 || indexes[1] > len
                || indexes[0] == indexes[1]) {
            System.out.println("Wrong enter!");
        } else {
            if (indexes[0] > indexes[1]) {
                int tmp = indexes[0];
                indexes[0] = indexes[1];
                indexes[1] = tmp;
            }
            System.out.println("Result: " + buildString(indexes, str));
        }
    }

}
