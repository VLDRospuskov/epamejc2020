package main.homeworks.hw5.recursion_2;

import java.util.Scanner;

public class Exponentiation {
    
    public void run() {
        int[] input = scanNumberAndPow();

        if (input[1] == 1) {
            System.out.println(input[0]);
        } else if (input[1] == 0) {
            System.out.println(1);
        } else {
            System.out.println("Result: "+ exponentiation(input[0], input[0], input[1]));
        }
    }
    
    
    public int[] scanNumberAndPow() {
        int[] input = new int[2];

        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Please enter number: ");
            input[0] = scan.nextInt();
            System.out.print("Please enter pow: ");
            input[1] = scan.nextInt();
            if(input[1] < 0) {
                System.out.println("Enter positive pow!");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Wrong enter!" + e);
        } finally {
            scan.close();
        }

        return input;
    }
    
    
    private static int exponentiation(int n, int tmp, int exp) {
        tmp = tmp * n;

        if (exp == 2) {
            return tmp;
        }

        exp--;

        return exponentiation(n, tmp, exp);
    }
}
