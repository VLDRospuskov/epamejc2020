package main.homework2.strings.task4;

import java.io.*;

public class ReverseWords {
    static {
        System.out.println("Enter some string." + "\n" + "To end the program - enter \"exit\".");
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //перезапуск программы в цикле; если введено "exit" - завершение
    protected void start() {
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
