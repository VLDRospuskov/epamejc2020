package homework5.RecursionFibonacci;

import java.util.Scanner;

class recursionFibonacciLogic {

    private int count;

    void run()
    {
        getCount();
        recursionFibonacci recursionFibonacci = new recursionFibonacci();
        System.out.println(recursionFibonacci.feb(count));
    }

    private void getCount()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count: ");
        count = Integer.parseInt(in.nextLine());
    }


}

