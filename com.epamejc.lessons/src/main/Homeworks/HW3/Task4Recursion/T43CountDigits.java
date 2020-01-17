package main.Homeworks.HW3.Task4Recursion;

import java.util.Scanner;

public class T43CountDigits {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(count(input));
        }
    }

    private int count(int number) {
        if (number / 10 == 0) {
            return 1;
        } else {
            return 1 + count(number / 10);
        }
    }
}
