package Home_works.HW2.Number3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void readAndPut() {
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.readLine();
                reverseWord(inputString);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }


    protected  void reverseWord(String inputString) {
        String[] strin = inputString.split(" ");
        for (String word : strin) {
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
        }
        System.out.println();
    }
}
