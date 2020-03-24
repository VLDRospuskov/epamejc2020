package homework.hw5;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class CountDigits43 {

    public static void main(String... args) {
        MainTemplate.main(CountDigits43::countDigits);
    }

    static int count(long n) {
        if (n / 10 == 0) {
            return 1;
        }
        return count(n / 10) + 1;
    }

    static int countDigits(BufferedReader reader) {
        try {
            System.out.print("Введите число: ");
            String sNumber = reader.readLine();
            long nNumber = Long.parseLong(sNumber);

            return count(nNumber);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return countDigits(reader);
        }
    }
}
