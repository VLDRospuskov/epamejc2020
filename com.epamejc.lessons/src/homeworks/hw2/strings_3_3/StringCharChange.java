package homeworks.hw2.strings_3_3;

import java.util.*;

public class StringCharChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "";
        int ind1 = 0;
        int ind2 = 0;
        int len = 0;
        System.out.print("Please enter text: ");
        try {
            str = scan.nextLine();
            len = str.length() - 1;
            System.out.print("Please enter indexes between 0 and " + len + ": ");
            ind1 = scan.nextInt();
            ind2 = scan.nextInt();

        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        if (ind1 < 0 || ind1 > len || ind2 < 0 || ind2 > len || ind1 == ind2) {
            System.out.println("Wrong enter!");
        } else {
            if (ind1 > ind2) {
                int tmp = ind1;
                ind1 = ind2;
                ind2 = tmp;
            }

            String output = "";
            output = str.substring(0, ind1) + str.charAt(ind2) + str.substring(ind1 + 1, ind2) + str.charAt(ind1) + str.substring(ind2 + 1, str.length());
            System.out.println(output);
        }
    }
}
