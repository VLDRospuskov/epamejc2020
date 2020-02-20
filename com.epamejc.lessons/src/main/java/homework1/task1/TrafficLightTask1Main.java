package homework1.task1;

import HomeworksReaderAndPrinter.ConsolePrinter;
import HomeworksReaderAndPrinter.ConsoleReader;

public class TrafficLightTask1Main {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start(new ConsoleReader(), new ConsolePrinter());
    }
}