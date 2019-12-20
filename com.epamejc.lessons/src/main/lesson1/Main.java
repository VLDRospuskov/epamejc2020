package main.lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String min;
        while (true) {
            System.out.print("Enter sec (-1 to exit): ");
            min = in.nextLine();
            System.out.println();
            if (isNum(min)) {
                if (Integer.parseInt(min) >= 0 && Integer.parseInt(min) < 4) {
                    System.out.println("Green");

                } else if (Integer.parseInt(min) >= 4 && Integer.parseInt(min) < 6) {
                    System.out.println("Yellow");

                } else if (Integer.parseInt(min) >= 6 && Integer.parseInt(min) <= 10) {
                    System.out.println("Red");

                } else if (Integer.parseInt(min) == (-1)) {
                    return;
                } else {
                    System.out.println("Error1");

                }
            } else {
                System.out.println("Error2");
            }
//            switch (Integer.parseInt(sec)) {
//                case (-1): {
//                    return;
//                }
//                case 0 - 180: {
//                    System.out.print("Green");
//                    break;
//                }
//                case (181 - 300): {
//                    System.out.print("Yellow");
//                    break;
//                }
//                case (301 - 600): {
//                    System.out.print("Red");
//                    break;
//                }
//                default: {
//                    System.out.print("Error"+Integer.parseInt(sec));
//                    break;
//                }
//            }
        }
    }

    public static Boolean isNum(String str) {
        return str.matches("[-+]?\\d+");
    }
}
