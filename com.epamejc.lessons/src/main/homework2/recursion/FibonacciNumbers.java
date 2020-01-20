package main.homework2.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbers {
    public static void main(String[] args) {
        FibonacciNumbers fib = new FibonacciNumbers();
        fib.go();
    }
    public void go(){
        String start = "Введите число";

        String dataAlert = "Некорректные данные";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(start);
            String number = reader.readLine();

            try {
                int num = Integer.parseInt(number);
                if (num >0){
                    int result = fibonacci(num);
                    System.out.println(result);
                } else {
                    System.out.println(dataAlert);
                }
            } catch (Exception ex){
                System.out.println(dataAlert);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private int fibonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);

    }

}
