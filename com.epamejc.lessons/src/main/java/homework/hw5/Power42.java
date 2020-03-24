package homework.hw5;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Power42 {

    public static void main(String... args) {
        MainTemplate.main(Power42::funcPow);
    }

    static int power(int n, int p) {
        if (p <= 0) {
            return 1;
        }
        return power(n, p - 1) * n;
    }

    static int funcPow(BufferedReader reader) {
        try {
            System.out.print("Введите число: ");
            String sNumber = reader.readLine();
            int nNumber = Integer.parseInt(sNumber);

            System.out.print("Введите степень: ");
            String sPower = reader.readLine();
            int nPower = Integer.parseInt(sPower);

            return power(nNumber, nPower);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return funcPow(reader);
        }
    }
}
