package lesson2;

import java.util.Scanner;

public class Task43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        System.out.println(NumCounter(Integer.parseInt(in.nextLine())));
    }

    public static int NumCounter(int num) {
        int col = 1;
        if (num / 10 == 0) {
            return 1;
        } else {

            col += NumCounter(num / 10);
        }
        return col;


    }
}
