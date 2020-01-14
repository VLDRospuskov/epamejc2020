package main.lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String min;
        boolean exit = true;
        while (exit) {
            System.out.print("Enter sec (-1 to exit): ");
            min = in.nextLine();
            System.out.println();
            if (Integer.parseInt(min) == (-1)) {
                break;
            }
            System.out.print(selectColor(min));
        }
    }

    public static Boolean isNum(String str) {
        return str.matches("[-+]?\\d+");
    }

    public static String selectColor(String min) {

        if (isNum(min)) {
            if (Integer.parseInt(min) >= 0 && Integer.parseInt(min) < 4) {
                return ("Green");

            } else if (Integer.parseInt(min) >= 4 && Integer.parseInt(min) < 6) {
                return ("Yellow");

            } else if (Integer.parseInt(min) >= 6 && Integer.parseInt(min) <= 10) {
                return ("Red");

            } else {
                return ("Error");

            }
        } else {
            return ("Error");
        }
    }
}
