package lesson2;

import java.util.Scanner;

public class Task34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = new String(in.nextLine().toString());
        int firstWord = 0;
        int Space = 0;
        String strToReverse;
        while (true) {
            Space = str.toString().indexOf(" ", Space);// find index of space
            if (Space == -1) {
                strToReverse = str.substring(firstWord, str.length());
                System.out.println(new StringBuffer(strToReverse).reverse());
                break;
            } else {
                strToReverse = str.substring(firstWord, Space);
                System.out.println(new StringBuffer(strToReverse).reverse());
                firstWord = Space;
                Space += 1;
            }
        }
    }
}
