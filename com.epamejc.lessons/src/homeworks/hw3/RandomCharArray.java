package homeworks.hw3;

import java.util.Random;
import java.util.Scanner;

public class RandomCharArray {

    public static Integer[] getSizeFromInput() {
        Integer[] answer = new Integer[2];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter x: ");
        answer[0] = in.nextInt();

        System.out.println("Enter y: ");
        answer[1] = in.nextInt();

        return answer;
    }

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

    public static void getAndPrintArray() {
        Integer[] sizeArray = getSizeFromInput();

        Integer x = sizeArray[0];
        Integer y = sizeArray[1];

        char[][] charArray = randomizeCharArray(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(charArray[i][j] + " ");
            }
            System.out.println();
        }
    }

}
