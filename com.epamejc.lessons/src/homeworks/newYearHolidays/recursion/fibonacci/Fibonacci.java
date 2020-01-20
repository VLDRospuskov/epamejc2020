package homeworks.newYearHolidays.recursion.fibonacci;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(fibonacci(n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int fibonacci (int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
