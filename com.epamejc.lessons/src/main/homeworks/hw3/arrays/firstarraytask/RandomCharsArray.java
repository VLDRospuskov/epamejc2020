package main.homeworks.hw3.arrays.firstarraytask;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

import static main.homeworks.hw3.arrays.firstarraytask.enums.Messages.FROM_TO_MESSAGE;

class RandomCharsArray {

    static void getCharsArray(int lines, int columns) {

        char[][] charArray = new char[lines][columns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                Random r = new Random();
                charArray[i][j] = (char) (r.nextInt(26) + 'a');
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
    }
}
