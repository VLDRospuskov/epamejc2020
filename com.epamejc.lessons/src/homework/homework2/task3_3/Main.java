package homework.homework2.task3_3;

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
            char[] str = getNotEmptyString(bufReader).toCharArray();
            System.out.println("Your parent string: " + new String(str));
            System.out.println("Print two comma separated char position between 0 and " + (str.length - 1) + " or 'exit' to close the program");
            int charPosition1;
            int charPosition2;
            String line;
            while (true) {
                try {
                    line = bufReader.readLine();
                    line = line.replace(" ", "");
                    String[] positions = line.trim().split(",");
                    if (positions.length == 1 && positions[0].equals("exit")) {
                        System.out.println("Bye-bye!");
                        return;
                    } else if (positions.length == 2) {
                        charPosition1 = Integer.parseInt(positions[0]);
                        charPosition2 = Integer.parseInt(positions[1]);
                    } else {
                        System.err.println("Wrong Input! Two comma separated non-negative integer values expected or \"exit\".");
                        continue;
                    }
                    if (charPosition1 < 0 || charPosition1 > str.length - 1 ||
                            charPosition2 < 0 || charPosition2 > str.length - 1) {
                        System.err.println("Parent string does not have this position.Try again!");
                    } else {
                        char temp = str[charPosition1];
                        str[charPosition1] = str[charPosition2];
                        str[charPosition2] = temp;
                        System.out.println("Output: " + new String(str));
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Wrong Input! Two comma separated non-negative integer values expected or \"exit\".");
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
