package homework4.RecursionFibonacci;

import java.util.Scanner;

class RecursionFibonacci {

    private int count;

    void run()
    {
        getCount();
        System.out.println(Feb(count));
    }

    private void getCount()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count: ");
       count = Integer.parseInt(in.nextLine());

    }

    private  int Feb(int col) {
        if (col == 0){
            return 0;
        }
        if (col == 1){
            return 1;
        }
        else{
            return Feb(col - 1) + Feb(col - 2);
        }
    }
}

