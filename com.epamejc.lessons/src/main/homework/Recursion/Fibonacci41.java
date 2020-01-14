package homework.Recursion;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Fibonacci41 {
    public static void main(String[] args) { MainTemplate.main(Fibonacci41::funcFib); }

    private static long FibNaive(int n) {
        if (n <= 1) {
            return n;
        }
        return FibNaive(n - 1) + FibNaive(n - 2);

    }
    private static Long funcFib (BufferedReader reader) {
        try {
            System.out.print("Введите небольшое число: ");
            String snum = reader.readLine();
            int nnum = Integer.parseInt(snum);
            return FibNaive(nnum);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return funcFib(reader);
        }
    }
}

