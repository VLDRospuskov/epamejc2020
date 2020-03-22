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
        width = readCom("Enter width ");
        height = readCom("Enter height ");
    }

    private int readCom(String text) {
        int command = 0;
        boolean t;
        do {
            try {
                System.out.print(text);
                Scanner in = new Scanner(System.in);
                command = in.nextInt();
                t = false;
            } catch (Exception e) {
                t = true;
                System.out.println("Input Error.");
            }
        } while (t);
        return command;
    }



}