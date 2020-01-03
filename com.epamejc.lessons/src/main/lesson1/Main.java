package main.lesson1;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.timer(1);
        trafficLight.timer("1");
        trafficLight.timer("1:10");
    }
}
