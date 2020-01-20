package lesson2;

import javax.swing.*;
import java.util.Scanner;

public class Task32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = (in.nextLine());
        StringBuilder finl= new StringBuilder();
        boolean exit = true;
        int min;
        while (true) {
            System.out.print("Enter sec(1 to " + str.length() + "; -1 to exit): ");
            min = Integer.parseInt(in.nextLine());
            if ((min) == (-1)) {
                break;
            }
            if ((min >= 1 && (min <= str.length()))) {
                finl.append(str.charAt(min-1));
                System.out.println(finl);
            } else {
                System.out.println("Err");
            }


        }
    }
}
