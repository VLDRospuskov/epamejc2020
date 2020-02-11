package com.epamejc.lessons.src.homework.homework1.trafficlight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starter {
    public void start() {
        TrafficLight trafficLight = new TrafficLight();
        String newLine = "";
        int value;
        System.out.println("Print integer value between 0 and 10 to change color of traffic light or 'exit' to close the program");
        try (BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    newLine = bufReader.readLine();
                    value = Integer.parseInt(newLine);
                    trafficLight.setColor(value);
                    System.out.println("Traffic Light : " + trafficLight.getColor());
                } catch (IllegalArgumentException e) {
                    if (newLine.equals("exit")) {
                        System.out.println("Bye-bye!");
                        return;
                    } else {
                        System.err.println("Wrong Input!" + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An unexpected I/O error has occurred.");
        }
    }
}
