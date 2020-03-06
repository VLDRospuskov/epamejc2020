package homework3.ArrayRandomCharRactangle;

import java.util.Scanner;

public class randomCharRectangle {
    private int width = 0;
    private int height = 0;

    public void run() {
        getWH();
        randomCharRectangleLogic randomCharRectangleLogic = new randomCharRectangleLogic();
        System.out.println(randomCharRectangleLogic.buildRectangle(height,width));
    }

    private void getWH() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter width ");
        width = Integer.parseInt(in.nextLine());
        System.out.print("Enter height ");
        height = Integer.parseInt(in.nextLine());
    }



}