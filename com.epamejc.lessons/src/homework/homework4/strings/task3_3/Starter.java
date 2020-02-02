package homework.homework4.strings.task3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        System.out.println("Print not empty parent string:");
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            char[] str = getNotEmptyString(bufReader).toCharArray();
            System.out.println("Your parent string: " + new String(str));
            System.out.println("Print two comma separated char position between 0 and " + (str.length - 1) +
                    " or 'exit' to close the program");
            while (true) {
                if (workCycle(bufReader, str)) return;
            }
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }

    private boolean workCycle(BufferedReader bufReader, char[] str) throws IOException {
        int charPosition1;
        int charPosition2;
        try {
            String[] positions = getPositionWords(bufReader);
            if (positions.length == 1 && positions[0].equals("exit")) {
                System.out.println("Bye-bye!");
                return true;
            } else if (positions.length == 2) {
                charPosition1 = Integer.parseInt(positions[0]);
                charPosition2 = Integer.parseInt(positions[1]);
                if (checkErrorCharPosition(str, charPosition1, charPosition2)) {
                    System.err.println("Parent string does not have this position.Try again!");
                } else {
                    char temp = str[charPosition1];
                    str[charPosition1] = str[charPosition2];
                    str[charPosition2] = temp;
                    System.out.println("Output: " + new String(str));
                }
            } else {
                System.err.println("Invalid parameters number.Try again!");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Wrong Input! Two comma separated non-negative integer values expected or \"exit\".");
        }
        return false;
    }

    private String[] getPositionWords(BufferedReader bufReader) throws IOException {
        String line;
        line = bufReader.readLine();
        line = line.replace(" ", "");
        return line.trim().split(",");
    }

    private boolean checkErrorCharPosition(char[] str, int charPosition1, int charPosition2) {
        return (charPosition1 < 0 || charPosition1 > str.length - 1 ||
                charPosition2 < 0 || charPosition2 > str.length - 1);
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
