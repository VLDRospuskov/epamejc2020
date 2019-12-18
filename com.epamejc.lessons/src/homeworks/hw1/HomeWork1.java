package homeworks.hw1;

import java.util.Scanner;

/*
 *********** Traffic Light ***********
 */
public class HomeWork1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int n;
        boolean isEnd = false;
        while (!isEnd) {
            System.out.print("Enter number(enter \"-1\" to exit): ");
            str = sc.nextLine();
            try {
                n = Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println("Wrong enter! Please enter number!");
                continue;
            }
            if (n == -1) {
                isEnd = true;
                break;
            }
            if (n < -1) {
                n = -n;
            }
            if (n > 10) {
                while (n > 10) {
                    n = n % 10;
                }
            }
            if (n >= 0 && n <= 3) {
                System.out.println("Traffic signal: Green");
            } else if (n >= 4 && n <= 5) {
                System.out.println("Traffic signal: Yellow");
            } else {
                System.out.println("Traffic signal: Red");
            }
        }
        sc.close();
    }
}
