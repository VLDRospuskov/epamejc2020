package homework5.RecursionExponentiate;

import java.util.Scanner;

public class recursionExponentialLogic {

    private int num;
    private int pow;

    public void run() {
        getNumPow();
        recursionExponential recursionExponential = new recursionExponential();
        System.out.println(recursionExponential.step(num, pow));
    }

    private void getNumPow() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = Integer.parseInt(in.nextLine());
        System.out.print("Enter pow: ");
        pow = Integer.parseInt(in.nextLine());
    }

}
