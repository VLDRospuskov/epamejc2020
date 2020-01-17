package main.homeworks.hw2.strings_3_2;

import java.util.Scanner;

public class StringByIndex {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String str = "";

        System.out.print("Please enter text: ");
        try {
            str = scan.nextLine();
        } catch (Exception e) {
            System.out.println("Error! " + e);
        }

        int index = 0;
        String output = "";
        boolean loop = true;
        String msg = "Please enter index between 0 and " + (str.length() - 1) + " (-1 to exit): ";

        while (loop) {
            Scanner scan2 = new Scanner(System.in);
            System.out.print(msg);
            try {
                index = scan2.nextInt();
            } catch (Exception e) {
                System.out.println("Error! " + e);
            }

            if (index == -1 ) { //
                break;
            }

            if (index < 0 || index > str.length() - 1) {
                System.out.println("Wrong index!");
                continue;
            } else {
                output += str.charAt(index);
                System.out.println(output);
            }
        }

    }
}
