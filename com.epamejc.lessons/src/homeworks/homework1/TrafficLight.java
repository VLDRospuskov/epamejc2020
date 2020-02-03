package homeworks.homework1;

import java.util.Scanner;

public class TrafficLight {

    private Scanner sc;

    public TrafficLight(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("Enter time in seconds. Exit by entering empty line: ");
        changeLight();
    }

    private void changeLight() {
        String input;
        while (!(input = sc.nextLine()).isEmpty()) {
            try {
                int time = Integer.parseInt(input) % 600;
                if (time <= 180) {
                    System.out.println("GREEN");
                } else if (time <= 300) {
                    System.out.println("YELLOW");
                } else {
                    System.out.println("RED");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again: ");
            }
        }
    }
}
