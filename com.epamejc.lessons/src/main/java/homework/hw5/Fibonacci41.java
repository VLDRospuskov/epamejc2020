package homework.hw5;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Fibonacci41 {

    public static void main(String[] args) {
        MainTemplate.main(Fibonacci41::funcFib);
    }

    static long FibNaive(int n) {
        if (n <= 1) {
            return n;
        }

        return FibNaive(n - 1) + FibNaive(n - 2);
    }

    static Long funcFib(BufferedReader reader) {
        try {
            System.out.print("Введите небольшое число: ");
            String sNumber = reader.readLine();
            int nNumber = Integer.parseInt(sNumber);

            return FibNaive(nNumber);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return funcFib(reader);
        }
    }
}

