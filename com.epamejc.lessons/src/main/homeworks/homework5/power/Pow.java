package main.homeworks.homework5.power;

import java.util.Scanner;

public class Pow {
    public void run() {
        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.print("Enter power: ");
        int power = scanner.nextInt();
        System.out.print(number + " in "+ power + " : " + powerInt(number,power));
        scanner.close();
    }

    private int powerInt(int number, int power) {
        if (power == 0)
            return 1;
        if (power == 1)
            return number;
        return number*powerInt(number,power-1);
    }
}
