package homework.homework3.strategyCharGenerator;

import homework.homework3.allInAll.Colors;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class RandomArray {

    char[][] create (int rows, int columns) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random randomInteger = new Random();
        char[][] randomChars = new char[rows][columns];
        System.out.println("\n**************StrategyCharGenerator***************");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomChars[i][j] = alphabet.charAt(randomInteger.nextInt(alphabet.length()));
                System.out.print(Colors.colors[ThreadLocalRandom.current().nextInt(1, 9)]
                        + " " + randomChars[i][j] + " " + Colors.colors[0]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        return randomChars;
    }
}
