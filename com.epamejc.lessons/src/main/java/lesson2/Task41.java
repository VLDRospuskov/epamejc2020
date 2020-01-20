package lesson2;

import java.util.Scanner;

public class Task41 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter count: ");
        System.out.println(Feb(Integer.parseInt(in.nextLine())));
    }

    private static int Feb(int col) {
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

