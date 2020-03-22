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
        num = readCom("Enter number: ");
        pow = readCom("Enter pow: ");
    }

    private int readCom(String text) {
        boolean t;
        int command = 0;
        do {
            try {
                System.out.print(text);
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t = false;
            } catch (Exception e) {
                t = true;
                System.out.println("Input Error.");
            }
        } while (t);
        return command;
    }

}
