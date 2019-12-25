package com.epam.homeworks.homework1;
import java.util.Scanner;

public class TrafficLights {
    static String colorLight;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Traffic lights on. To turn off the traffic light, enter \"off\". " +
                "Enter the number of minutes to switch the color: ");
        String input = in.nextLine();
        while (!input.equals("off")) {
            try {
                changeLight(Integer.parseInt(input));
            } catch (Exception e) {
                System.out.println("Opps... We don't know this command.");
            }

            input = in.nextLine();
        }
        System.out.print("You turned off the traffic lights.");
    }

    private static void changeLight (int min) {
        if (min >= 0 && min <= 3) {
            colorLight = "Green";
        }
        if (min >= 4 && min <= 5) {
            colorLight = "Yellow";
        }
        if (min >= 6 && min <= 10) {
            colorLight = "Red";
        }
        System.out.println(colorLight);
    }
}
