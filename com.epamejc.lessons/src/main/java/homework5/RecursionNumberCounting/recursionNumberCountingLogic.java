package homework5.RecursionNumberCounting;

import java.util.Scanner;

public class recursionNumberCountingLogic {

    private int num;

    public void run() {
        getNum();
        recursionNumberCounting recursionNumberCounting = new recursionNumberCounting();
        System.out.println(recursionNumberCounting.numCounter(num));
    }

    private void getNum() {
        num = readCom("Enter number: ");
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
