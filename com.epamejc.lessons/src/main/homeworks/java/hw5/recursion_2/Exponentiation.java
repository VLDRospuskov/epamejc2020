package homeworks.java.hw5.recursion_2;

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

    /**
     * I did not close the Scanner because:
     * https://coderanch.com/wiki/678613/Don-close-Scanner-tied-System
     * https://www.omnijava.com/2018/08/23/if-you-are-using-javas-scanner-class-for-keyboard-input-then-you-might-be-doing-it-wrong/
     * https://stackoverflow.com/questions/52040576/scanner-close-method-closes-all-scanners-why
     */
    private int[] scanNumberAndPow() {
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
        }

        return input;
    }
    
    
    public int exponentiation(int num, int tmp, int exp) {
        tmp = tmp * num;

        if (exp == 2) {
            return tmp;
        }

        exp--;

        return exponentiation(num, tmp, exp);
    }
}
