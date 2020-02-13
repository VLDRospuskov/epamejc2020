package Homeworks.HW3.Task2Arrays;

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

        scanner.close();

        System.out.println(print2dArray(a, b));
    }

    public String print2dArray(int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print((char) getRandomInt() + " ");
                sb.append((char) getRandomInt() + " ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    private int getRandomInt() {
        return (int) ((Math.random() * (126 - 33)) + 33);
    }
}
