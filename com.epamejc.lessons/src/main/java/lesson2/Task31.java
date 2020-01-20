package lesson2;

import java.util.Scanner;

public class Task31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = in.nextLine().toString();
        System.out.print("Enter strategy(A or B) ");
        String typeOfStrategy = (in.nextLine());
        applyStrategy(str,typeOfStrategy);
    }

    private static void applyStrategy(String str, String strategy) {
        int i = 0;
        if ((strategy.equals("B")) || (strategy.equals("b"))) {
            i = 1;
        }
        while (i < str.length()) {
            System.out.print(str.charAt(i));
            i += 2;
        }
    }
}
