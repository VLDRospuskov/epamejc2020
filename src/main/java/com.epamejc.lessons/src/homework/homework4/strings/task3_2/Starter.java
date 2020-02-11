package com.epamejc.lessons.src.homework.homework4.strings.task3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        System.out.println("Print not empty parent string:");
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = getNotEmptyString(bufReader);
            System.out.println("Your parent string: " + str);
            System.out.println("Print char position between 0 and " + (str.length() - 1) + " to add char to output" +
                    " or 'exit' to close the program");
            StringBuilder output = new StringBuilder();
            while (true) {
                try {
                    if (!appendChar(bufReader, output, str)) {
                        System.out.println("Bye-bye");
                        return;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Wrong Input! Non-negative integer value expected or \"exit\".");
                }
            }
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }


    private boolean appendChar(BufferedReader bufReader, StringBuilder output, String startStr)
            throws IllegalArgumentException, IOException {
        String readStr = bufReader.readLine();
        if (readStr.equals("exit")) {
            return false;
        }
        int charPosition = Integer.parseInt(readStr);
        if (charPosition < 0 || charPosition > startStr.length() - 1) {
            System.err.println("Parent string does not have this position.Try again!");
        } else {
            output.append(startStr.charAt(charPosition));
            System.out.println("Input: " + charPosition + " Output:" + output.toString());
        }
        return true;
    }


    private String getNotEmptyString(BufferedReader bufReader) throws IOException {
        if (bufReader == null) {
            throw new IllegalArgumentException("BufferedReader is null!");
        }
        while (true) {
            String line = bufReader.readLine();
            if (line.isEmpty()) {
                System.err.println("String must be not empty! Try again.");
            } else {
                return line;
            }
        }
    }
}
