package homework.homework2.strategyCharGenerator;

import java.util.Random;

class StrategyB {
    void setRandomChars (int rows, int columns) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random randomInteger = new Random();
        char[][] randomChars = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomChars[i][j] = alphabet.charAt(randomInteger.nextInt(alphabet.length()));
                System.out.print(randomChars[i][j]);
            }
        }
        System.out.print("\n\n");
    }
}
