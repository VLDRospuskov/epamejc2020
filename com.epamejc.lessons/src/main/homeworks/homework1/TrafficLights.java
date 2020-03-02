package main.homeworks.homework1;

import java.util.Scanner;

public class TrafficLights {

    public void run() {
        System.out.print("Traffic lights on. To turn off the traffic light, enter \"off\". " +
                "Enter the number of minutes to switch the color: ");
        inputNumber();
        System.out.print("You turned off the traffic lights.");
    }

    public void inputNumber() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int n;
        while (!input.equals("off")) {
            try {
                n = Integer.parseInt(input);
                if (n < 0 || n > 10) {
                    throw new ArithmeticException();
                }
                System.out.println(changeLight(n));
            } catch (ArithmeticException e) {
                System.out.println("Enter a positive number less than 10!");
            } catch (Exception e) {
                System.out.println("Opps... We don't know this command.");
            }
            input = in.nextLine();
        }
        in.close();
    }

    public String changeLight(int min) {
        Colors current = null;
        if (min >= 0 && min <= 3) {
            current = Colors.Green;
        }
        if (min >= 4 && min <= 5) {
            current = Colors.Yellow;
        }
        if (min >= 6 && min <= 10) {
            current = Colors.Red;
        }
        return current.toString();
    }

}
