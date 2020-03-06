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
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        num = Integer.parseInt(in.nextLine());
    }

}
