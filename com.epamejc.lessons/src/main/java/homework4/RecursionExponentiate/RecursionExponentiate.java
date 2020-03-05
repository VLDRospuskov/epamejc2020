package homework4.RecursionExponentiate;

import java.util.Scanner;

public class RecursionExponentiate {

    private int num;
    private int pow;

    public void run() {
        getNumPow();
        System.out.println(Step(num, pow));
    }

    private void getNumPow() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = Integer.parseInt(in.nextLine());
        System.out.print("Enter pow: ");
        pow = Integer.parseInt(in.nextLine());

    }

    private static int Step(int num, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow == 1) {
            return num;
        }
        return num * Step(num, pow - 1);
    }
}
