package main.java.homework4.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() {
        System.out.println("Enter some string." + "\n" + "To end the program - enter \"exit\".");
        try {
            while (true) {
                System.out.println("Enter the string:");
                String inputString = reader.readLine();
                if (!inputString.equals("exit")) {
                    reverseWord(inputString);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void reverseWord(String inputString) {
        String[] words = inputString.split(" ");
        for (String word : words) {
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
        }
        System.out.println();
    }
}
