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
                System.out.println("Wrong enter! Please enter number between 0 to 10.");
                continue;
            }
            if (n == -1) {
                isEnd = true;
                break;
            } else if (n >= 0 && n <= 3) {
                System.out.println("Traffic signal: Green");
            } else if (n >= 4 && n <= 5) {
                System.out.println("Traffic signal: Yellow");
            } else if (n >= 6 && n <= 10) {
                System.out.println("Traffic signal: Red");
            } else {
                System.out.println("Wrong enter! Please enter number between 0 to 10.");
            }
        }
        sc.close();
    }
}
