package main.java.homework3.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CreatePyramid {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    protected void start() {
        System.out.println("Enter the integer - it will be height of your pyramid." + "\n" +
                "To end the program - enter \"exit\".");
        try {
            while (true) {
                String height = reader.readLine();
                if (!height.equals("exit")) {
                    createArray(height);
                } else {
                    reader.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    private void createArray(String height) {
        try {
            int intHeight = Integer.parseInt(height);
            String[][] xArray = new String[intHeight][intHeight];
            for (String[] s : xArray) {
                Arrays.fill(s, "X");
            }
            createPyramid(xArray);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input.Try again.");
        }
    }

    private void createPyramid(String[][] xArray) {
        for (int i = xArray.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print(xArray[i][j]);
            }
            System.out.println();
        }
    }
}
