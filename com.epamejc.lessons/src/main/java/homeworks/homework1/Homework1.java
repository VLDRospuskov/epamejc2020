package homeworks.homework1;

import homeworks.InputReader;

public class Homework1 {
    
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        int minutes;
        do {
            System.out.println("Input minutes value");
            minutes = InputReader.nextInt();
            System.out.println(trafficLight.getColor(minutes));
        } while (minutes >= 0);
    }
    
}