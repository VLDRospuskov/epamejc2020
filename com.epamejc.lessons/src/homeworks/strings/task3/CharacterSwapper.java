package homeworks.strings.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterSwapper {

    private Scanner sc;
    private String inputString;
    private int index1;
    private int index2;

    public CharacterSwapper(Scanner sc) {
        this.sc = sc;
    }

    private String swap(int index1, int index2) {
        char[] chars = inputString.toCharArray();
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
        return new String(chars);
    }

    public void run() {
        input();
        System.out.println(swap(index1, index2));
    }

    private void input() {
        System.out.println("Input string: ");
        inputString = sc.nextLine();
        System.out.println("Input char positions to swap (0 - " + (inputString.length() - 1) + "): ");
        try {
            index1 = sc.nextInt();
            index2 = sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input");
        }
    }
}
