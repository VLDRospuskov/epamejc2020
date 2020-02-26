package homeworks.HM0_TrafficLight;

import org.junit.Test;

import java.io.*;

/**
 * //TODO
 * можно ли делать тесты без ассерта?
 * Если с ним, то необходимо делать очень много тестов?
 * делать ассерт со строками?
 */

public class TrafficLightTest {

    private TrafficLight trafficLight = new TrafficLight();

    String[] inputValues = new String[]{
            "1\n2\n3\n4\n0",
            "5\n6\n7\n0",
            "8\n9\n10\n0",
            "-1\n-5\n11\n12\n0",
            "1.0\n10.0\n11.\n0",
            "not a number\n\n \n?\n0"
    };

    private InputStream getInputStreamFromString(String str) {
        byte[] bytes = str.getBytes();
        return new ByteArrayInputStream(bytes);
    }

    @Test
    public void launchGreen() {
        System.out.println("Test launchGreen");
        trafficLight.setReader(getInputStreamFromString(inputValues[0]));

        trafficLight.launch();
    }

    @Test
    public void launchYellow() {
        System.out.println("Test launchYellow");

        trafficLight.setReader(getInputStreamFromString(inputValues[1]));

        trafficLight.launch();
    }

    @Test
    public void launchRed() {
        System.out.println("Test launchRed");

        trafficLight.setReader(getInputStreamFromString(inputValues[2]));

        trafficLight.launch();
    }

    @Test
    public void launchOutOfBorders() {
        System.out.println("Test launchOutOfBorders");

        trafficLight.setReader(getInputStreamFromString(inputValues[3]));

        trafficLight.launch();
    }

    @Test
    public void launchWrongNumbers() {
        System.out.println("Test launchWrongNumbers");

        trafficLight.setReader(getInputStreamFromString(inputValues[4]));

        trafficLight.launch();
    }

    @Test
    public void launchWrongStrings() {
        System.out.println("Test launchWrongStrings");

        trafficLight.setReader(getInputStreamFromString(inputValues[5]));

        trafficLight.launch();
    }
}
