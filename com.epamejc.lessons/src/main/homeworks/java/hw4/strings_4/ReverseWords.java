package homeworks.java.hw4.strings_4;

import java.util.Scanner;

public class ReverseWords {

    public void run() {
        String str = scanString();
        String[] words = reverseWordsInString(str);
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
        }
    }

    public String scanString() {
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

        return str;
    }

    public String[] reverseWordsInString(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            String revStr = "";
            for (int j = words[i].length() - 1; j >= 0 ; j--) {
                revStr += words[i].charAt(j);
            }
            words[i] = revStr;
        }

        return words;
    }

}
