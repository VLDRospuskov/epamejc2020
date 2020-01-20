package lesson2;

import java.util.Scanner;

public class Task42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = Integer.parseInt(in.nextLine());
        System.out.print("Enter pow: ");
        int pow = Integer.parseInt(in.nextLine());
        System.out.println(Step(num, pow));
    }

    public static int Step(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return num;
        }
        return num * Step(num, pow - 1);
    }
}
