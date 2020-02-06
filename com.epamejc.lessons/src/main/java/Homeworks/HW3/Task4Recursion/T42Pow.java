package Homeworks.HW3.Task4Recursion;

import java.util.Scanner;

public class T42Pow {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number: ");
        int num = scanner.nextInt();
        System.out.println("input pow: ");
        int pow = scanner.nextInt();
        System.out.println(pow(num, pow));
    }

    private int pow(int num, int pow) {
        if (pow < 0) {
            return 0;
        } else if (pow == 0) {
            return 1;
        } else if (pow == 1) {
            return num;
        } else {
            return num * pow(num, pow-1);
        }
    }
}
