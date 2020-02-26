package homeworks.java.hw3.arrays;

import java.util.Random;

import static homeworks.java.hw3.enums.Messages.WARNING_FOR_PARSING_TO_INT;

class SecondArray {

    private char[][] getCharsArray(int n) {
        char[][] charArray = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                charArray[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        return charArray;
    }

    String strategyAOutput(String in) {
        String strategyAOutput = new String();
        try {
            int n = Integer.parseInt(in);

            char[][] charArray = getCharsArray(n);

            System.out.println("Strategy A output");
            for (int i = 0; i < charArray.length; ) {
                for (int j = 0; j < charArray[0].length; ) {
                    strategyAOutput = strategyAOutput + charArray[i][j];
                    j = j + 2;
                }
                i = i + 2;
            }
            System.out.println(strategyAOutput);
            System.out.println("\n");
        } catch (NumberFormatException e) {
            System.out.println(WARNING_FOR_PARSING_TO_INT);
        }
        return strategyAOutput;
    }

    String strategyBOutput(String in) {
        String strategyBOutput = new String();
        try {
            int n = Integer.parseInt(in);

            char[][] arrayB = getCharsArray(n);

            System.out.println("Strategy B output");

            for (int i = 1; i < arrayB.length; ) {
                for (int j = 1; j < arrayB.length; ) {
                    strategyBOutput = strategyBOutput + arrayB[i][j];
                    j = j + 2;
                }
                i = i + 2;
            }
            System.out.println(strategyBOutput);
            System.out.println("\n");
        } catch (NumberFormatException e) {
            System.out.println(WARNING_FOR_PARSING_TO_INT);
        }
        return strategyBOutput;
    }

}
