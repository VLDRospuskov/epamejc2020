package homework.homework2.randomCharGenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

class CharGenerator {

    void generate () {
        System.out.print("Enter numbers in format 'rows columns': ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String userInput = reader.readLine();
                String[] rowsAndColumns = userInput.split(" ", 2);

                if (rowsAndColumns.length == 2 && isPositiveAndNotZero(rowsAndColumns[0]) && isPositiveAndNotZero(rowsAndColumns[1])) {

                    int rows = Integer.parseInt(rowsAndColumns[0]);
                    int columns = Integer.parseInt(rowsAndColumns[1]);

                    setRandomChars(rows, columns);
                    System.out.print("Enter again or type 'exit': ");

                } else if (userInput.equals("exit")) {
                    System.out.println("Generator stopped!");
                    break;
                } else {
                    System.out.println("Incorrect format");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void setRandomChars (int rows, int columns) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random randomInteger = new Random();
        char[][] randomChars = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomChars[i][j] = alphabet.charAt(randomInteger.nextInt(alphabet.length()));
                System.out.print(" " + randomChars[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    private boolean isPositiveAndNotZero (String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}


