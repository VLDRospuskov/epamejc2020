package main.homeworks.homework5.countDigits43;

import java.util.Scanner;

public class CountDigits {
    private int number;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        number = scanner.nextInt();
        System.out.println(count(number));
        scanner.close();
    }

    private int count(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + count(n/10) ;
    }
}
