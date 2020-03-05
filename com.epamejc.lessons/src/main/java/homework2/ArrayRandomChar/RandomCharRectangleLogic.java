package homework2.ArrayRandomChar;

import java.util.Random;
import java.util.Scanner;

public class RandomCharRectangleLogic {
    private int width = 0;
    private int height = 0;

    public void run() {
        getWH();
        RandomCharRectangle randomCharRectangle = new RandomCharRectangle();
        System.out.println(randomCharRectangle.buildRectangle(height,width));
    }

    private void getWH() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");
        height = Integer.parseInt(in.nextLine());
    }



}