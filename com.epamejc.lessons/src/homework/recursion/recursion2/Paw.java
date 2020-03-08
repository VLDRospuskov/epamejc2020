package homework.recursion.recursion2;

import java.util.Scanner;

public class Paw {
    private long number=26;
    private int paw=4;

    public void run () {
       input();
        System.out.println( paw(number,paw));
    }

    private long paw (long number, int paw) {
        if (paw==0)
            return 1;
        if (paw==1)
            return number;
        return number*paw(number,paw-1);
    }
    private void input () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number and its power: ");
        number = scanner.nextLong();
        paw = scanner.nextInt();
    }
}
