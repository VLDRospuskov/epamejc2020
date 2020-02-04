package main.homeworks.hw4.strings_2;

import java.util.Scanner;

public class GenerateStringFromInputStringByIndex {

    public void run() {
        String str = scanInputString();
        buildStringInLoop(str);
    }

    public void buildStringInLoop(String str) {
        String output = "";
        boolean loop = true;

        while (loop) {
            int index = scanIndex(str);
            if (index == -1) {
                break;
            } else if (index < 0 || index > str.length() - 1) {
                System.out.println("Wrong index!");
                continue;
            } else {
                output += str.charAt(index);
                System.out.println(output);
            }
        }
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

    public int scanIndex(String str) {
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
