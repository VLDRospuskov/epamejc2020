package homeworks.homework1;

import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time in seconds. Exit by entering empty line: ");
        String input = sc.nextLine();

        while (!input.isEmpty()) {
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
            input = sc.nextLine();
        }
    }
}
