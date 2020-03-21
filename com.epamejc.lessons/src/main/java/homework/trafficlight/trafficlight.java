package main.java.homework.trafficlight;

import java.util.Scanner;
public class trafficlight {

    public static void main(String[] args) {

        double timer;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the time ");
            timer = scanner.nextDouble();
        }
        while (timer<0);
        timer=timer%10;
        if (timer>=0 && timer <4)
        {
            System.out.println("green");
        }
        else if (timer>3 && timer <6)
        {
            System.out.println("yellow");
        }
        else
        {
            System.out.println("red");
        }
    }
}