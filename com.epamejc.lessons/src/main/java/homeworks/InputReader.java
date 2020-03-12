package homeworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    
    public static String nextString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }
    
    public static int nextInt() {
        int value = 0;
        try {
            value = Integer.parseInt(nextString());
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format");
            System.out.println("Input val = 0 now");
            e.printStackTrace();
        }
        return value;
    }
    
}
