package main.homeworks.homework5.power;

import java.util.Scanner;

public class Pow {

    int number;
    int power;

    public void run() {
        System.out.print("Enter number: ");
        number = input();
        System.out.print("Enter power: ");
        power = input();
        System.out.print(number + " in "+ power + " : " + powerInt(number,power));
    }

    private int input() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Enter integer.");
            scanner.next();
        }
        int value = scanner.nextInt();
        return value;
    }

    private int powerInt(int number, int power) {
        if (power == 0)
            return 1;
        if (power == 1)
            return number;
        return number*powerInt(number,power-1);
    }

}
