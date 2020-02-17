package homework2.T11RecursionNumberCounting;

import java.util.Scanner;

public class RecursionNumberCounting {

    private int num;

    public void run() {
        getNum();
        System.out.println(NumCounter(num));
    }

    private void getNum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = Integer.parseInt(in.nextLine());
    }

    private static int NumCounter(int num) {
        int col = 1;
        if (num / 10 == 0) {
            return 1;
        } else {
            col += NumCounter(num / 10);
        }
        return col;
    }
}
