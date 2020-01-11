package main.Homeworks.HW3.Task2Arrays;

import java.util.Scanner;

/*
2.2. Сгенерировать массив массивов указав размерность, заполнить его случайными символами. Написать 2 стратегии, которые будут формировать строку на основе данного массива. Стратегия А - работает по принципу *_*_*, а стратегия B - работает по принципу _*_*_ . Пример:
input: 5 5
output:
d a l p j
v c b z g
a d l r f
f d m x h
k d l h b
input strategy: A
output: dljalfklb

 */

public class T22TwoDimensionalWithString {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Strategy: ");
        String s = scanner.next();

        boolean sA = false;
        boolean sB = false;

        if (s.equals("A")) {
            sA = true;
        } else if (s.equals("B")) {
            sB = true;
        } else {
            System.out.println("Wrong input");
            return;
        }

        String out = "";

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                char c = (char) getRandomInt();
                if (sA && (i%2==0) && (j%2==0)) {
                    out = out + c;
                }
                if (sB && (i%2!=0) && (j%2!=0)) {
                    out = out + c;
                }
                System.out.print(c + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(out);

    }

    private int getRandomInt() {
        return (int) ((Math.random() * (126 - 33)) + 33);
    }
}
