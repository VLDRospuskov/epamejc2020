package homeworks.java.hw4.strings_2;

import java.util.Scanner;

public class GenerateStringFromInputStringByIndex {

    public void run() {
        String str = scanInputString();
        buildStringInLoop(str);
    }

    private String buildStringInLoop(String str) {
        String output = "";
        boolean loop = true;

        while (loop) {
            int index = scanIndex(str);
            if (index == -1) {
                loop = false;
            } else if (index < 0 || index > str.length() - 1) {
                System.out.println("Wrong index!");
                continue;
            } else {
                output += getCharByIndex(index, str);
                System.out.println(output);
            }
        }
        return output;
    }

    public char getCharByIndex(int index, String str) {
        return str.charAt(index);
    }

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    private String scanInputString() {
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

    private int scanIndex(String str) {
        final String MSG = "Please enter index between 0 and " + (str.length() - 1) + " (-1 to exit): ";
        int index = 0;
        Scanner scan2 = new Scanner(System.in);

        try {
            System.out.print(MSG);
            index = scan2.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong enter! " + e);
        }

        return index;
    }

}
