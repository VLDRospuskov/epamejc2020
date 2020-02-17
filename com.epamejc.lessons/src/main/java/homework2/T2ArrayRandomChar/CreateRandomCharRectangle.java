package homework2.T2ArrayRandomChar;

import java.util.Random;
import java.util.Scanner;

public class CreateRandomCharRectangle {
    private int width = 0;
    private int height = 0;

    public CreateRandomCharRectangle() {
        this.getWH();
        this.buildRectangle();
    }

    private void getWH() {


        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        this.width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");
        this.height = Integer.parseInt(in.nextLine());
    }

    private void buildRectangle() {
        Random r = new Random();
        char[][] arr = new char[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                arr[i][j] = (char) (r.nextInt(94) + 33);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}