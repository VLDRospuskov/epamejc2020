package homeworks.java.hw3.arrays;

import java.util.Random;

import static homeworks.java.hw3.enums.Messages.WARNING_FOR_PARSING_TO_INT;

class FirstArray {

    char[][] getCharsArray(String inLines, String inColumns) {
        try {
            int lines = Integer.parseInt(inLines);
            int columns = Integer.parseInt(inColumns);

            char[][] charArray = new char[lines][columns];

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < columns; j++) {
                    Random r = new Random();
                    charArray[i][j] = (char) (r.nextInt(26) + 'a');
                    System.out.print(charArray[i][j]);
                }
                System.out.println();
            }
            return charArray;
        } catch (Exception e) {
            System.out.println(WARNING_FOR_PARSING_TO_INT);
        }
        return null;
    }

}
