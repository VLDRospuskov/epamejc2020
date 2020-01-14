package homework.Recursion;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class CountNums43 {
    public static void main(String... args) {
        MainTemplate.main(CountNums43::countNums);
    }

    public static int count(long n) {
        if (n / 10 == 0) {
            return 1;
        }
        return count(n / 10) + 1;
    }


    private static int countNums(BufferedReader reader) {
        try {
            System.out.print("Введите число: ");
            String snum = reader.readLine();
            long nnum = Long.parseLong(snum);
            return count(nnum);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return countNums(reader);
        }
    }
}
