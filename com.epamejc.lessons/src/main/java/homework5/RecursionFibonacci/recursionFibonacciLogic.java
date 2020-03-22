package homework5.RecursionFibonacci;

import java.util.Scanner;

class recursionFibonacciLogic {

    private int count;

    void run() {
        getCount();
        recursionFibonacci recursionFibonacci = new recursionFibonacci();
        System.out.println(recursionFibonacci.feb(count));
    }

    private void getCount()
    {
        count = readCom("Enter count: ");
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

