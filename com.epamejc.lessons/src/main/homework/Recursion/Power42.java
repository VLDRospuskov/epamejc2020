package homework.Recursion;

import homework.MainTemplate;

import java.io.BufferedReader;
import java.io.IOException;

public class Power42 {
    public static void main(String... args) {
        MainTemplate.main(Power42::funcPow);
    }

    public static int power(int n, int p) {
        if (p == 0){
            return 1;
        }
        return  power(n, p-1) * n;
    }
    private static int funcPow (BufferedReader reader){
        try {
            System.out.print("Введите число: ");
            String snum = reader.readLine();
            int nnum = Integer.parseInt(snum);
            System.out.print("Введите степень: ");
            String spow = reader.readLine();
            int npow = Integer.parseInt(spow);
            return power(nnum, npow);
        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
            return funcPow(reader);
        }
    }
}
