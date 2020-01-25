package main.HM4_Recursion;

import java.util.Scanner;

public class RecursionTasks {
    public static void main(String[] args) {
        readInt();

//        fibonacci(value);
//
//        System.out.print("Enter power: ");
//        Scanner sc = new Scanner(System.in);
//        int pow = sc.nextInt();
//        System.out.println(power(value, pow));

        System.out.println(numberOfDigits(value));
    }

    private static int value;
    private static void readInt() {
        System.out.print("Enter int: ");
        Scanner sc = new Scanner(System.in);
        value = sc.nextInt();
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int power(int a, int b){
        if (b == 1) return a;
        return a * power(a,b-1);
    }

    public static int numberOfDigits(int n) {
        if (n/10 < 1) return 1;
        return numberOfDigits(n/10) + 1;
    }
}

/*
4. Recursion
4.1. Поиск числа Фиббоначи
4.2. Написать программу которая умеет вовзодить в степени:
input number: 4
input pow: 3
output: 64
4.3.  Посчитать количество знаков в числе
 */