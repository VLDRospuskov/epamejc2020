package homework.arrays;

import java.util.Scanner;

public class array1 {

    public static void main(String[] args) {
        double rand_num;
        Scanner in = new Scanner(System.in);
        System.out.print("Input height: ");
        int m = in.nextInt();
        System.out.print("Input length: ");
        int n = in.nextInt();
        char[] [] charArray = new char[m][n];



        for (int i = 0; i < charArray.length; i++){
            for(int j=0; j < charArray[i].length; j++){
                do {
                    rand_num = Math.random();
                    rand_num = rand_num * 1000;
                } while (rand_num < 97 || rand_num > 122);

                char random = (char) rand_num;
                charArray[i][j] = random;
                System.out.printf("%c ", charArray[i][j]);
            }
            System.out.println();
        }
    }
}