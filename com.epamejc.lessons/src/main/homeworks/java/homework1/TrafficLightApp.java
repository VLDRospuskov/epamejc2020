package main.homeworks.java.homework1;

import java.util.Scanner;

public class TrafficLightApp {

   private TrafficLight trafficLight;
   private Scanner sc;

    public TrafficLightApp(Scanner sc) {
        this.sc = sc;
        trafficLight = new TrafficLight();
    }

    public void run() {
        System.out.println("Enter time in seconds. Exit by entering empty line: ");
        input();
    }

    private void input() {
        String input;
        while (!(input = sc.nextLine()).isEmpty()) {
            trafficLight.changeLight(input);
        }
    }
}
