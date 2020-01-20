package main.HW2.Number4_1;

/*Поиск числа Фибоначчи*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.println("Write index of element you want to look at: ");
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int number = Integer.parseInt(str);

        System.out.print("Result: ");
        System.out.print(fibonacci(number));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
