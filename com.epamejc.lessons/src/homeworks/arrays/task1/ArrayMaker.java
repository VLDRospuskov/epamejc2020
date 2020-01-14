package homeworks.arrays.task1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayMaker {

    private Scanner sc;
    private int dimension1;
    private int dimension2;

    public ArrayMaker(Scanner sc) {
        this.sc = sc;
    }

    private char[][] makeArray(int a, int b) {
        char[][] result = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                result[i][j] = getRandomChar();
            }
        }
        return result;
    }

    private void printArray(char[][] array) {
        for (int i = 0; i < dimension1; i++) {
            for (int j = 0; j < dimension2; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char getRandomChar() {
        Random rand = new Random();
        char c = (char) (rand.nextInt(26) + 'a');
        return c;
    }

    private void getInput() {
        try {
            dimension1 = sc.nextInt();
            dimension2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
        }
    }

    public void run() {
        System.out.println("Enter array size (int int): ");
        getInput();
        printArray(makeArray(dimension1, dimension2));
    }
}
