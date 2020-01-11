package main.Homeworks.HW3.Task2Arrays;

/*
2.1. Создать массив массивов, задается размерность на основании которое генерируются случайные символы типа char. Пример:
Input: 4 2
output:
k c
b p
b h
h g
*/

import java.util.Scanner;

public class T21TwoDimensional {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print((char) getRandomInt() + " ");
            }
            System.out.println(" ");
        }

    }

    private int getRandomInt() {
        return (int) ((Math.random() * (126 - 33)) + 33);
    }
}
