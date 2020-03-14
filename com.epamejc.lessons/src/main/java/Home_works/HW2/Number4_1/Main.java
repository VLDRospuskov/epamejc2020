package Home_works.HW2.Number4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        int number = Integer.parseInt(reader("Write index of element you want to look at: "));

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

    public static String reader(String s) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String srt = null;
        try {
            System.out.println(s);
            srt = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return srt;
    }
}
