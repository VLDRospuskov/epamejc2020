package main.lesson1.homework;

import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        System.out.println("Welcome to TrafficLight!");
        System.out.println("Please enter time to check whether the light is Green, Yellow or Red.");
        System.out.println("Provide time in MM:SS format. 0 < MM < 10, 0 < SS < 60.");
        System.out.println("To quit program enter \"q\".");

        boolean isWorking = true;

        Scanner scanner = new Scanner(System.in);

        while (isWorking) {
            String str = scanner.nextLine();
            System.out.println("work");
            System.out.println(str);

            if (str.contains(":")) {
                System.out.println("let's do it!");
                String[] strParts = str.split(":");
                if (strParts.length == 2) {
                    int minutes = Integer.parseInt(strParts[0]);
                    int seconds = Integer.parseInt(strParts[1]);
                    if (minutes < 0 || minutes > 10) {
                        System.out.println("Minutes out of bounds!");
                        continue;
                    }
                    if (seconds < 0 || seconds > 60) {
                        System.out.println("Seconds out of bounds!");
                        continue;
                    }
                } else {
                    incorrectInputMessage();
                }
            } else if (str.equals("q")) {
                // exit
                System.out.println("Thank you for using TrafficLight. Bye!");
                isWorking = false;
                scanner.close();
            } else {
                incorrectInputMessage();
            }
        }



    }
    private static void incorrectInputMessage() {
        System.out.println("Please provide input in supported format!");
    }
}
