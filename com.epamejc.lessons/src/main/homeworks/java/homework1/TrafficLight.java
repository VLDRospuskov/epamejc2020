package main.homeworks.java.homework1;

import static main.homeworks.java.homework1.Lights.*;

public class TrafficLight {

    public Lights changeLight(String input) {
        Lights light = RED;
        try {
            int time = Integer.parseInt(input) % 600;
            if (time <= 180) {
                light = GREEN;
            } else if (time <= 300) {
                light = YELLOW;
            } else {
                light = RED;
            }
            System.out.println(light);
        } catch (Exception e) {
            System.out.println("Invalid input. Try again: ");
        }
        return light;
    }
}
