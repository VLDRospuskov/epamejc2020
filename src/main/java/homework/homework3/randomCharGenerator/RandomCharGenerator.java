package homework.homework3.randomCharGenerator;

import homework.homework3.allInAll.Colors;
import homework.homework3.allInAll.ThreadController;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCharGenerator {

    public void generate(String userInput) {

        String[] rowsAndColumns = userInput.split(" ", 2);

        if (rowsAndColumns.length == 2 && isPositiveAndNotZero(rowsAndColumns[0]) && isPositiveAndNotZero(rowsAndColumns[1])) {

            int rows = Integer.parseInt(rowsAndColumns[0]);
            int columns = Integer.parseInt(rowsAndColumns[1]);

            generateArray(rows, columns);

        } else {
            System.out.println("Format for random char generator should be: (int)rows (int)columns");
        }

    }


    private void generateArray(int rows, int columns) {
        synchronized (ThreadController.sync) {
            final String alphabet = "abcdefghijklmnopqrstuvwxyz";
            Random randomInteger = new Random();
            char[][] randomChars = new char[rows][columns];
            System.out.println("\n**************RandomCharGenerator*************");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    randomChars[i][j] = alphabet.charAt(randomInteger.nextInt(alphabet.length()));
                    System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)]
                            + " " + randomChars[i][j] + " " + Colors.colors[0]);
                }
                System.out.print("\n");
            }
        }
    }


    private boolean isPositiveAndNotZero(String str) {
        String regexInteger = "^-?\\d+$";
        return str.matches(regexInteger) && Integer.parseInt(str) > 0;
    }
}


