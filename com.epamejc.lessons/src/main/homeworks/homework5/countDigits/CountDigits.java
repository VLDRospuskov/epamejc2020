package main.homeworks.homework5.countDigits;

import java.util.Scanner;

public class CountDigits {

    private int number;

    public void run() {
        System.out.print("Enter number: ");
        input();
        System.out.println(count(number));
    }

    private void input() {
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Enter integer.");
            input();
        }
        scanner.close();
    }

    private int count(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + count(n/10) ;
    }

}
