package HW2.Number4_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        int count = Integer.parseInt(reader("Write your number: "));

        System.out.print("Result: ");
        System.out.print(countOfNumbers(count));
    }

    static int countOfNumbers(int count) {
        if (count / 10 != 0)
            return 1 + countOfNumbers(count / 10);
        else
            return 1;
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
