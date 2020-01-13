package homework.homework2.task3_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Print string:");
            String line = bufReader.readLine();
            String result = getStringWithReversedWords(line);
            System.out.println("Output: " + result);

        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private String getStringWithReversedWords(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line is null");
        }
        String[] words = line.trim().split("\\s");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                strBuilder.append(word.charAt(i));
            }
            result.append(strBuilder.toString()).append(" ");
        }
        result.setLength(result.length() - 1); //delete last whitespace
        return result.toString();
    }

}
