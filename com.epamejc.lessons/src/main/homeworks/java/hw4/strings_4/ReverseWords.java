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

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    private String scanString() {
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
