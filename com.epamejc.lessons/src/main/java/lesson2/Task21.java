package lesson2;


import java.util.Random;
import java.util.Scanner;

public class Task21 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        int width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");
        int height = Integer.parseInt(in.nextLine());
        char[][] arr = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <width ; j++) {
                arr[i][j]= (char)(r.nextInt(94)+33);
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
