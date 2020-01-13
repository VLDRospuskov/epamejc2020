package homework.homework2.task3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        new Main().start();

    }

    public void start() {
        System.out.println("Print not empty parent string:");
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = getNotEmptyString(bufReader);
            System.out.println("Your parent string: " + str);
            System.out.println("Print char position between 0 and " + (str.length() - 1) + " to add char to output or 'exit' to close the program");
            int charPosition;
            String line = "";
            StringBuilder output = new StringBuilder();
            while (true) {
                try {
                    line = bufReader.readLine();
                    charPosition = Integer.parseInt(line);
                    if (charPosition < 0 || charPosition > str.length() - 1) {
                        System.err.println("Parent string does not have this position.Try again!");
                    } else {
                        output.append(str.charAt(charPosition));
                        System.out.println("Input: " + charPosition + " Output:" + output.toString());
                    }
                } catch (IllegalArgumentException e) {
                    if (line.equals("exit")) {
                        System.out.println("Bye-bye!");
                        return;
                    } else {
                        System.err.println("Wrong Input! Non-negative integer value expected or \"exit\".");
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private String getNotEmptyString(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String line = bufReader.readLine();
            if (line.isEmpty()) {
                System.out.println("String must be not empty! Try again.");
            } else {
                return line;
            }
        }
    }

}
