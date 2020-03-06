package homeworks.hw3;

import java.util.Scanner;

public class Pyramid {

    public static Integer getInputHeight() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pyramid height: ");
        Integer height = in.nextInt();

        return height;
    }

    public static void buildPyramid() {
        Integer size = getInputHeight();
        char[] pyrArray = new char[size];
        for (int i = 0; i < size; i++) {
            pyrArray[i] = 'X';
        }
        for (int i = size; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(pyrArray[j]);
            }
            System.out.println();
        }
    }
}
