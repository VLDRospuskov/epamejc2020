package homeworks.holidaysHW.arrays;

import java.util.Random;

public class RandomCharArray {

    public static char[][] randomizeCharArray(int x, int y) {
        char[][] charArray = new char[x][y];
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                charArray[i][j] = (char) (rand.nextInt(26) + 'a');
            }
        }
        return charArray;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 2;
        char[][] charArray = randomizeCharArray(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println();
        }
    }

}
