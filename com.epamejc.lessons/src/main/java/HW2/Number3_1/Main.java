package HW2.Number3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String strOdd = "2";

        String str = reader("Write your sentence: ");

        String method = reader("Write strategy even or odd (choose 1 or 2): ");

        char[] strToChar = str.toCharArray();

        if (method.equals(strOdd)) {
            for (int i = 0; i < strToChar.length; i++) {
                if (i % 2 == 0) {
                    System.out.print(strToChar[i]);
                }
            }
        } else {

            for (int i = 0; i < strToChar.length; i++) {
                if (i % 2 != 0) {
                    System.out.print(strToChar[i]);
                }
            }
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
