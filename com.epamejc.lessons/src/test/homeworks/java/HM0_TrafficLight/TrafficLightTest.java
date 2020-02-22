package homeworks.java.HM0_TrafficLight;

import org.junit.Test;

import java.io.*;

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
        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }

    @Test
    public void launchYellow() {
        System.out.println("Test launchYellow");

        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }

    @Test
    public void launchRed() {
        System.out.println("Test launchRed");

        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[2]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }

    @Test
    public void launchOutOfBorders() {
        System.out.println("Test launchOutOfBorders");

        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[3]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }

    @Test
    public void launchWrongNumbers() {
        System.out.println("Test launchWrongNumbers");

        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[4]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }

    @Test
    public void launchWrongStrings() {
        System.out.println("Test launchWrongStrings");

        try {
            trafficLight.setReader(getInputStreamFromString(inputValues[5]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trafficLight.launch();
    }
}
