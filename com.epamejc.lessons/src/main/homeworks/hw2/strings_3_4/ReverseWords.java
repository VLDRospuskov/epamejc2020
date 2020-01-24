package main.homeworks.hw2.strings_3_4;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = "";

        try {
            System.out.print("Please enter text: ");
            str = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        } finally {
            scan.close();
        }

        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            String revStr = "";
            for (int j = words[i].length() - 1; j >= 0 ; j--) {
                revStr += words[i].charAt(j);
            }
            words[i] = revStr;
        }

        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
        }
    }
}
