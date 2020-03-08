package HW2.Number4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        int num1 = Integer.parseInt(reader("Write your number: "));
        int num2 = Integer.parseInt(reader("Write the power: "));
        System.out.print("Result: ");
        System.out.println(pow(num1, num2));

    }

    static int pow(int number, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return number;
        }
        return number * pow(number, pow - 1);
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

