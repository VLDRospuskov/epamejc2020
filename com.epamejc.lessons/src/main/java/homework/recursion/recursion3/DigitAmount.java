package main.java.homework.recursion.recursion3;

import java.util.Scanner;

public class DigitAmount {
    private int num;

    public void run () {
        numReader();
        System.out.println(amountOfNum(num));

    }

    private int amountOfNum (int num) {
        if (num/10!=0) {
            return 1+amountOfNum(num/10);
        } else
            return 1;

    }
    private void numReader () {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
    }

}