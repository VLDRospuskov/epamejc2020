package homework.arrays;
import java.util.Scanner;


public class array2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Input height: ");
        int m = in.nextInt();
        System.out.print("Input length: ");
        int n = in.nextInt();
        char[][] charArray = new char[m][n];
        double rand_num;

        int i;
        int j;
        for (i = 0; i < charArray.length; i++) {
            for ( j = 0; j < charArray[i].length; j++) {
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

      System.out.println("Choose the strategy A or B ");
        in = new Scanner(System.in);
       String strategy = in.nextLine();


      if (strategy.equals("A") || strategy.equals("a")) {
          for (i = 0; i < charArray.length; i += 2) {
              for (j = 0; j < charArray[i].length; j += 2) {
                  System.out.printf("%c ", charArray[i][j]);
              }
          }
      }

       else if (strategy.equals("B") || strategy.equals("b")) {
          for (i = 1; i < charArray.length; i += 2) {
              for (j = 1; j < charArray[i].length; j += 2) {
                  System.out.printf("%c ", charArray[i][j]);
              }
          }
      }
    }
}