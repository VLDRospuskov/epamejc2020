package lesson2;

import java.util.Scanner;

public class Task23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter height ");

        int height = Integer.parseInt(in.nextLine()) + 1;
        if (height == 0) {
            return;
        }
        String str = "X";
        StringBuilder strrepeat = new StringBuilder(str.repeat(height));
        for (int i = 0; i < height; i++) {
            strrepeat.setLength(strrepeat.length() - 1);
            System.out.println(strrepeat.toString());
        }
    }


}

